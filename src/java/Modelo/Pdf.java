/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import com.itextpdf.text.*;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.*;
import java.awt.Font;
import java.io.FileOutputStream;
import java.util.Calendar;

/**
 *
 * @author Kevin
 */
public class Pdf {

    public void CrearPDF() {
        Document doc = new Document(PageSize.A9, 36, 72, 108, 108);
        PdfWriter docWriter = null;
        String rutaArch = "C:\\Users\\user\\Desktop\\";
        String rutaImg = "C:\\Users\\user\\Documents\\GitHub\\PruebaBDA\\web\\Img\\hotel.png";
        try {

            Calendar Fecha;
            String Fecha_Final;
            Fecha = Calendar.getInstance();
            int segundo = Fecha.get(Calendar.SECOND);
            int minuto = Fecha.get(Calendar.MINUTE);
            int hora = Fecha.get(Calendar.HOUR_OF_DAY);
            int Dia = Fecha.get(Calendar.DAY_OF_MONTH);
            int Mes = Fecha.get(Calendar.MONTH) + 1;
            int Anio = Fecha.get(Calendar.YEAR);
            Image logo = Image.getInstance(rutaImg);
            logo.scaleToFit(170, 170);
            logo.setAlignment(Chunk.ALIGN_LEFT);
            logo.scalePercent(35f);
            logo.setBorderColor(BaseColor.MAGENTA);

            System.out.println("Fecha: " + hora);
            String path = rutaArch + "Jess" + ".pdf";
            docWriter = PdfWriter.getInstance(doc, new FileOutputStream(path));
            doc.addAuthor("HospedajeReal");
            doc.addCreationDate();
            doc.addProducer();
            doc.addCreator("HospedajeReal.com");
            doc.addTitle("Contrato");
            doc.setPageSize(PageSize.LETTER);

            doc.open();

            int numero = (int) (Math.random() * 1500) + 1;
            BarcodeQRCode qrcode = new BarcodeQRCode(" f", (int) 0.25, (int) 0.25, null);
            Image qrcodeImage = qrcode.getImage();
            qrcodeImage.setAbsolutePosition(530, 720);
            qrcodeImage.scalePercent(400);
            doc.add(qrcodeImage);

            PdfPTable tab = new PdfPTable(1);
            Paragraph La1 = new Paragraph("Numero recibo", FontFactory.getFont("Segoe Print", 24, Font.BOLD, BaseColor.DARK_GRAY));
            PdfPCell tna = new PdfPCell(new Phrase(La1));
            tna.setBorder(0);
            Paragraph La = new Paragraph("" + numero, FontFactory.getFont("Segoe Print", 18, Font.PLAIN, BaseColor.CYAN));
            PdfPCell tnb = new PdfPCell(new Phrase(La));
            tnb.setBorder(0);
            tab.addCell(tna);
            tab.addCell(tnb);

            PdfPTable tablaN = new PdfPTable(7);
            PdfPCell tn = new PdfPCell(tab);
            tn.setBorder(0);
            PdfPCell tn1 = new PdfPCell(qrcodeImage);
            tn1.setBorder(0);
            tn.setColspan(4);
            tn.setBorder(0);
            tn1.setColspan(3);
            tn1.setBorder(0);

            tablaN.addCell(tn);
            tablaN.addCell(tn1);

            PdfPTable tablaT = new PdfPTable(7);

            Paragraph Lo = new Paragraph("HOSPEDAJE REAL", FontFactory.getFont("Segoe Print", 27, Font.BOLD, BaseColor.PINK));

            PdfPCell ta = new PdfPCell(Lo);
            PdfPCell tb = new PdfPCell(qrcodeImage);
            tb.setBorder(0);

            ta.setColspan(6);
            ta.setBorder(0);

            PdfPCell t = new PdfPCell(logo);
            t.setBorder(Rectangle.NO_BORDER);
            t.setColspan(2);
            PdfPCell t1 = new PdfPCell();
            t1.setBorder(Rectangle.NO_BORDER);

            tablaT.addCell(t);
            //tablaT.addCell(t1);
            tablaT.addCell(ta);
            //tablaT.addCell(tb);

            PdfPTable tE = new PdfPTable(1);

            PdfPCell e = new PdfPCell(new Phrase("\n\n"));
            e.setBorder(Rectangle.NO_BORDER);

            tE.addCell(e);

            //Paragraph Titulo = new Paragraph("Hotel", FontFactory.getFont("Segoe Print", 24, Font.ITALIC, BaseColor.DARK_GRAY));
            //Paragraph Titulo1= new Paragraph("PASO REAL", FontFactory.getFont("Broadway", 24, Font.TRUETYPE_FONT, BaseColor.DARK_GRAY));
            //Titulo.setAlignment(Element);
            PdfPTable tablaD = new PdfPTable(4);
            PdfPCell p = new PdfPCell(new Phrase("Nombre usuario"));
            p.setBackgroundColor(BaseColor.LIGHT_GRAY);
            PdfPCell p1 = new PdfPCell(new Phrase(" "));
            p1.setColspan(3);
            PdfPCell p2 = new PdfPCell(new Phrase("Nª de documento"));
            p2.setBackgroundColor(BaseColor.LIGHT_GRAY);
            PdfPCell p3 = new PdfPCell(new Phrase(" "));
            p3.setColspan(3);
            PdfPCell p4 = new PdfPCell(new Phrase("Numero reserva"));
            p4.setBackgroundColor(BaseColor.LIGHT_GRAY);
            PdfPCell p5 = new PdfPCell(new Phrase(" "));
            p5.setColspan(3);
            PdfPCell p6 = new PdfPCell(new Phrase("Numero Habitacion"));
            p6.setBackgroundColor(BaseColor.LIGHT_GRAY);

            tablaD.addCell(p);
            tablaD.addCell(p1);
            tablaD.addCell(p2);
            tablaD.addCell(p3);
            tablaD.addCell(p4);
            tablaD.addCell(p5);
            tablaD.addCell(p6);

            PdfPTable o = new PdfPTable(2);
            PdfPCell s = new PdfPCell(new Phrase("Alojamiento"));
            PdfPCell s1 = new PdfPCell(new Phrase("Servicios"));
            PdfPCell s2 = new PdfPCell(new Phrase("s"));
            PdfPCell s3 = new PdfPCell(new Phrase("a"));

            o.addCell(s);
            o.addCell(s1);
            o.addCell(s2);
            o.addCell(s3);

            PdfPTable tablaB = new PdfPTable(3);
            PdfPCell n = new PdfPCell(new Phrase("Total gastos"));
            PdfPCell nb = new PdfPCell(o);
            PdfPCell n1 = new PdfPCell(new Phrase("Empleado que elabora"));
            PdfPCell n2 = new PdfPCell(new Phrase("Hora de impresion"));
            PdfPCell n3 = new PdfPCell(new Phrase("Hora de salida"));
            PdfPCell n4 = new PdfPCell(new Phrase(""));
            PdfPCell n5 = new PdfPCell(new Phrase(""));
            PdfPCell n6 = new PdfPCell(new Phrase("Fecha: " + Dia + "/" + Mes + "/" + Anio + "      Hora: " + hora + ":" + minuto + ":" + segundo));
            PdfPCell n7 = new PdfPCell(new Phrase(""));
            PdfPCell n8 = new PdfPCell(new Phrase(""));
            PdfPCell B = new PdfPCell(new Phrase("\n\n"));
            PdfPCell B1 = new PdfPCell(new Phrase(""));
            PdfPCell B2 = new PdfPCell(new Phrase(""));
            //PdfPCell B3 = new PdfPCell(new Phrase(""));

            B.setBorder(Rectangle.NO_BORDER);
            B1.setBorder(Rectangle.NO_BORDER);
            B2.setBorder(0);
            //B3.setBorder(0);

            n.setBackgroundColor(BaseColor.LIGHT_GRAY);
            nb.setBorderWidthTop(3);
            nb.setColspan(2);
            n5.setColspan(2);
            n6.setColspan(2);

            n1.setBackgroundColor(BaseColor.LIGHT_GRAY);
            n2.setBackgroundColor(BaseColor.LIGHT_GRAY);
            n3.setBackgroundColor(BaseColor.LIGHT_GRAY);
            n4.setColspan(2);

            tablaB.addCell(B);
            tablaB.addCell(B1);
            tablaB.addCell(B2);
            //tablaB.addCell(B3);
            tablaB.addCell(n);
            tablaB.addCell(nb);
            tablaB.addCell(n1);
            tablaB.addCell(n4);
            tablaB.addCell(n2);
            tablaB.addCell(n6);
            tablaB.addCell(n3);
            tablaB.addCell(n5);

            //Paragraph SubTitulo = new Paragraph("DIVISIÓN DE RECURSOS HUMANOS", FontFactory.getFont("arial", 16, Font.BOLD, BaseColor.BLUE));
            //Paragraph Titulo_2 = new Paragraph("DESPRENDIBLE DE PAGO", FontFactory.getFont("arial", 12, BaseColor.RED));
            //Titulo.setAlignment(Element.ALIGN_CENTER);
            //doc.add(logo);
            doc.add(tablaN);
            doc.add(tablaT);
            doc.add(tE);
            doc.add(tablaD);
            doc.add(tablaB);
            doc.add(new Paragraph("Impreso: " + Dia + "-" + Mes + "-" + Anio));
            doc.add(new Paragraph("\n\n"));

            /*String myString = String.valueOf(Random1) + Codigo + String.valueOf(Random2) + Fecha_Final;
            Barcode128 code128 = new Barcode128();
            code128.setCode(myString.trim());
            code128.setCodeType(Barcode128.CODE128);
            Image code128Image = code128.createImageWithBarcode(cb, null, null);
            code128Image.setAbsolutePosition(10, 170);
            code128Image.scalePercent(125);
            doc.add(code128Image);

            code128.setCodeType(Barcode128.CODE128_UCC);
            code128Image = code128.createImageWithBarcode(cb, null, null);
            code128Image.setAbsolutePosition(10, 100);
            code128Image.scalePercent(125);
            doc.add(code128Image);

            BarcodeEAN codeEAN = new BarcodeEAN();
            codeEAN.setCode(myString.trim());
            codeEAN.setCodeType(BarcodeEAN.EAN13);
            Image codeEANImage = code128.createImageWithBarcode(cb, null, null);
            codeEANImage.setAbsolutePosition(10, 50);
            codeEANImage.scalePercent(125);
            doc.add(codeEANImage);

            BarcodeQRCode qrcode = new BarcodeQRCode(myString.trim(), 1, 1, null);
            Image qrcodeImage = qrcode.getImage();
            qrcodeImage.setAbsolutePosition(530, 720);
            qrcodeImage.scalePercent(200);
            doc.add(qrcodeImage);

            PdfPTable tabla = new PdfPTable(4);
            Paragraph Parrafo;
            tabla.addCell(Parrafo = new Paragraph("Año:", FontFactory.getFont("arial", 12, Font.BOLD, BaseColor.BLUE)));
            tabla.addCell("" + Anio);
            tabla.addCell(Parrafo = new Paragraph("Dias pagados:", FontFactory.getFont("arial", 12, Font.BOLD, BaseColor.BLUE)));
            tabla.addCell("30");
            //Primera Fila
            tabla.addCell(Parrafo = new Paragraph("Nombres y Apellidos:", FontFactory.getFont("arial", 12, Font.BOLD, BaseColor.BLUE)));
            //tabla.addCell(Propietario.toUpperCase());
            tabla.addCell(Parrafo = new Paragraph("Mes:", FontFactory.getFont("arial", 12, Font.BOLD, BaseColor.BLUE)));
            tabla.addCell("" + Mes);
            //Fila 2
            tabla.addCell(Parrafo = new Paragraph("Identificación:", FontFactory.getFont("arial", 12, Font.BOLD, BaseColor.BLUE)));
            tabla.addCell("888889993");
            tabla.addCell("");
            tabla.addCell("");
            //Fila 3
            tabla.addCell(Parrafo = new Paragraph("Cargo:", FontFactory.getFont("arial", 12, Font.BOLD, BaseColor.BLUE)));
            tabla.addCell("TECNICO EN NOSE");
            tabla.addCell("");
            tabla.addCell("");

            PdfPTable tabla_2 = new PdfPTable(2);

            PdfPCell celda1 = new PdfPCell();
            PdfPCell celda2 = new PdfPCell();

            PdfPTable TablaAnidada_1 = new PdfPTable(1);
            TablaAnidada_1.addCell(new Paragraph("Devengos", FontFactory.getFont("arial", 12, Font.BOLD, BaseColor.BLUE)));
            celda1.addElement(TablaAnidada_1);

            PdfPTable TablaAnidad_2 = new PdfPTable(2);
            TablaAnidad_2.addCell(new Paragraph("SUELDO BASICO"));
            TablaAnidad_2.addCell(new Paragraph("-------"));
            TablaAnidad_2.addCell(new Paragraph("BONIFICACIÓN DE HORAS EXTRA"));
            TablaAnidad_2.addCell("-----------");
            celda1.addElement(TablaAnidad_2);

            PdfPTable TablaAnidad_3 = new PdfPTable(2);
            TablaAnidad_3.addCell(new Paragraph("Descuentos", FontFactory.getFont("arial", 12, Font.BOLD, BaseColor.BLUE)));
            TablaAnidad_3.addCell(new Paragraph("Ctas/Pdt", FontFactory.getFont("arial", 12, Font.BOLD, BaseColor.BLUE)));

            PdfPTable TablaAnidada_4 = new PdfPTable(3);
            TablaAnidada_4.addCell("REGIMEN SALUD");
            TablaAnidada_4.addCell("");
            TablaAnidada_4.addCell("---");
            TablaAnidada_4.addCell("FONDO SOLIDARIO PENSIÓN");
            TablaAnidada_4.addCell("49,000");
            TablaAnidada_4.addCell("---");
            TablaAnidada_4.addCell("SISTEMA GRAL PENSIÓN");
            TablaAnidada_4.addCell("");
            TablaAnidada_4.addCell("---");

            celda2.addElement(TablaAnidad_3);
            celda2.addElement(TablaAnidada_4);

            PdfPTable TablaAux_1 = new PdfPTable(6);
            TablaAux_1.addCell(new Paragraph("Total Devengos:", FontFactory.getFont("arial", 12, Font.BOLD, BaseColor.BLUE)));
            TablaAux_1.addCell(new Paragraph("$", FontFactory.getFont("arial", 12, Font.BOLD, BaseColor.BLACK)));
            TablaAux_1.addCell(new Paragraph("Total Descuentos:", FontFactory.getFont("arial", 12, Font.BOLD, BaseColor.BLUE)));
            TablaAux_1.addCell(new Paragraph("$", FontFactory.getFont("arial", 12, Font.BOLD, BaseColor.BLACK)));
            TablaAux_1.addCell(" ");
            TablaAux_1.addCell(" ");
            TablaAux_1.addCell(new Paragraph("Neto a Pagar:", FontFactory.getFont("arial", 12, Font.BOLD, BaseColor.BLUE)));
            TablaAux_1.addCell(new Paragraph("$", FontFactory.getFont("arial", 12, Font.BOLD, BaseColor.BLACK)));
            TablaAux_1.addCell(" ");
            TablaAux_1.addCell(" ");
            TablaAux_1.addCell(" ");
            TablaAux_1.addCell(" ");
            tabla_2.addCell(celda1);
            tabla_2.addCell(celda2);
            //tabla_2.addCell(TablaAux_1);
            //tabla_2.addCell(TablaAux_2);

            doc.add(new PdfPTable(tabla));
            doc.add(new Paragraph("\n"));
            //Seginda Parte}
            doc.add(tabla_2);
            doc.add(TablaAux_1);*/
        } catch (DocumentException dex) {
            dex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (doc != null) {
                doc.close();
            }
            if (docWriter != null) {
                docWriter.close();
            }
        }
    }

}
