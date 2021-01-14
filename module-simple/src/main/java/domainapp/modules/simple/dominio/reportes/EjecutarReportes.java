package domainapp.modules.simple.dominio.reportes;
import domainapp.modules.simple.dominio.enums.Estado;
import domainapp.modules.simple.dominio.pagos.Pago;
import domainapp.modules.simple.dominio.socio.Socio;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.isis.applib.value.Blob;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import org.joda.time.LocalDate;

public class EjecutarReportes {

    public Blob ListadoSociosPDF(List<Socio> socios) throws JRException, IOException{

        List<SociosReporte> sociosReportes = new ArrayList<SociosReporte>();
        sociosReportes.add(new SociosReporte());

        for (Socio socio : socios) {

            if (socio.getEstado() == Estado.Activo){
                SociosReporte sociosReporte = new SociosReporte();

                sociosReporte.setNombre(socio.getNombre());
                sociosReporte.setApellido(socio.getApellido());
                sociosReporte.setDni(socio.getDni());
                sociosReporte.setTelefono(socio.getTelefono());

                sociosReportes.add(sociosReporte);

            }
        }

        JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(sociosReportes);
        return GenerarArchivoPDF("SociosReporte.jrxml", "Listado de Socios.pdf", ds);
    }

    public Blob ListadoPagosPDF(List<Pago> pagos) throws JRException, IOException{

        List<PagosReporte> pagosReportes = new ArrayList<PagosReporte>();
        pagosReportes.add(new PagosReporte());

        for (Pago pago : pagos) {

            int mes = LocalDate.now().getMonthOfYear();

            if (pago.getEstado() == Estado.Activo && pago.getFechaDePago().getMonthOfYear() == mes){
                PagosReporte pagosReporte = new PagosReporte();

                pagosReporte.setNombre(pago.getSocio().getNombre());
                pagosReporte.setApellido(pago.getSocio().getApellido());
                pagosReporte.setDni(pago.getSocio().getDni());
                pagosReporte.setMonto(pago.getMonto());
                pagosReporte.setFechaDePago(pago.getFechaDePago().toString("dd-MM-yyyy"));

                pagosReportes.add(pagosReporte);

            }
        }

        JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(pagosReportes);
        return GenerarArchivoPDF("PagosReporte.jrxml", "Listado de Pagos.pdf", ds);
    }

    private Blob GenerarArchivoPDF(String archivoDesing, String nombreSalida, JRBeanCollectionDataSource ds) throws JRException, IOException{

        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(archivoDesing);
        JasperDesign jasperDesign = JRXmlLoader.load(inputStream);
        JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("ds", ds);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, ds);
        byte[] contentBytes = JasperExportManager.exportReportToPdf(jasperPrint);

        return new Blob(nombreSalida, "application/pdf", contentBytes);
    }


}
