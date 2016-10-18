package salary.view;

import java.awt.Color;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Cell;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfWriter;

import salary.db.SalaryDataBean;

public class PaystubView extends AbstractPdfView {

	// @SuppressWarnings("unchecked")
	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		SalaryDataBean paystub = (SalaryDataBean) model.get("paystubs");

		BaseFont bfKorean = BaseFont.createFont("c:\\windows\\fonts\\batang.ttc,0", BaseFont.IDENTITY_H,
				BaseFont.EMBEDDED);

		Font font = new Font(bfKorean);

		Paragraph title = new Paragraph("급여명세서", font);
		title.setAlignment(Element.ALIGN_CENTER);

		document.add(title);
		document.add(new Paragraph("\r\n"));

		Table table = new Table(8);
		table.setPadding(5);

		Cell cell = null;

		// 성명
		cell = new Cell(new Paragraph("성명", font));
		cell.setHeader(true);
		cell.setColspan(2);
		cell.setBackgroundColor(Color.lightGray);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.addCell(cell);

		cell = new Cell(new Paragraph(paystub.getName(), font));
		cell.setColspan(2);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.addCell(cell);

		// 부서
		cell = new Cell(new Paragraph("부서", font));
		cell.setBackgroundColor(Color.lightGray);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.addCell(cell);

		cell = new Cell(new Paragraph(paystub.getCom_dept_name(), font));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.addCell(cell);

		// 직책
		cell = new Cell(new Paragraph("직책", font));
		cell.setBackgroundColor(Color.lightGray);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.addCell(cell);

		cell = new Cell(new Paragraph(paystub.getCom_pos_name(), font));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.addCell(cell);

		cell = new Cell(new Paragraph("지급항목", font));
		cell.setColspan(2);
		cell.setBackgroundColor(Color.lightGray);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.addCell(cell);

		cell = new Cell(new Paragraph("지급액", font));
		cell.setColspan(2);
		cell.setBackgroundColor(Color.lightGray);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.addCell(cell);

		cell = new Cell(new Paragraph("공제항목", font));
		cell.setColspan(2);
		cell.setBackgroundColor(Color.lightGray);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.addCell(cell);

		cell = new Cell(new Paragraph("공제액", font));
		cell.setColspan(2);
		cell.setBackgroundColor(Color.lightGray);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.addCell(cell);

		table.endHeaders();

		// 기본급
		cell = new Cell(new Paragraph("기본급", font));
		cell.setColspan(2);
		cell.setBackgroundColor(Color.lightGray);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.addCell(cell);

		cell = new Cell(new Paragraph(String.valueOf(paystub.getSalary_month()), font));
		cell.setColspan(2);
		cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.addCell(cell);

		// 소득세
		cell = new Cell(new Paragraph("소득세", font));
		cell.setColspan(2);
		cell.setBackgroundColor(Color.lightGray);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.addCell(cell);

		cell = new Cell(new Paragraph(String.valueOf(""), font));
		cell.setColspan(2);
		cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.addCell(cell);

		// 야근수당
		cell = new Cell(new Paragraph("야근수당", font));
		cell.setColspan(2);
		cell.setBackgroundColor(Color.lightGray);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.addCell(cell);

		cell = new Cell(new Paragraph(String.valueOf(paystub.getSalary_add_time()), font));
		cell.setColspan(2);
		cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.addCell(cell);

		// 주민세
		cell = new Cell(new Paragraph("주민세", font));
		cell.setColspan(2);
		cell.setBackgroundColor(Color.lightGray);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.addCell(cell);

		cell = new Cell(new Paragraph(String.valueOf(""), font));
		cell.setColspan(2);
		cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.addCell(cell);

		// 휴일수당
		cell = new Cell(new Paragraph("휴일수당", font));
		cell.setColspan(2);
		cell.setBackgroundColor(Color.lightGray);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.addCell(cell);

		cell = new Cell(new Paragraph(String.valueOf(paystub.getSalary_add_holiday()), font));
		cell.setColspan(2);
		cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.addCell(cell);

		// 고용보험
		cell = new Cell(new Paragraph("고용보험", font));
		cell.setColspan(2);
		cell.setBackgroundColor(Color.lightGray);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.addCell(cell);

		cell = new Cell(new Paragraph(String.valueOf(paystub.getTax_ui()), font));
		cell.setColspan(2);
		cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.addCell(cell);

		// 상여금
		cell = new Cell(new Paragraph("상여금", font));
		cell.setColspan(2);
		cell.setBackgroundColor(Color.lightGray);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.addCell(cell);

		cell = new Cell(new Paragraph(String.valueOf(paystub.getSalary_bonus()), font));
		cell.setColspan(2);
		cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.addCell(cell);

		// 국민연금
		cell = new Cell(new Paragraph("국민연금", font));
		cell.setColspan(2);
		cell.setBackgroundColor(Color.lightGray);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.addCell(cell);

		cell = new Cell(new Paragraph(String.valueOf(paystub.getTax_np()), font));
		cell.setColspan(2);
		cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.addCell(cell);

		// 식대
		cell = new Cell(new Paragraph("식대", font));
		cell.setColspan(2);
		cell.setBackgroundColor(Color.lightGray);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.addCell(cell);

		cell = new Cell(new Paragraph(String.valueOf(paystub.getCosts_food()), font));
		cell.setColspan(2);
		cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.addCell(cell);

		// 장기요양
		cell = new Cell(new Paragraph("장기요양", font));
		cell.setColspan(2);
		cell.setBackgroundColor(Color.lightGray);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.addCell(cell);

		cell = new Cell(new Paragraph(String.valueOf(paystub.getTax_lci()), font));
		cell.setColspan(2);
		cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.addCell(cell);

		// 교통비
		cell = new Cell(new Paragraph("교통비", font));
		cell.setColspan(2);
		cell.setBackgroundColor(Color.lightGray);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.addCell(cell);

		cell = new Cell(new Paragraph(String.valueOf(paystub.getCosts_transport()), font));
		cell.setColspan(2);
		cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.addCell(cell);

		// 건강보험
		cell = new Cell(new Paragraph("건강보험", font));
		cell.setColspan(2);
		cell.setBackgroundColor(Color.lightGray);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.addCell(cell);

		cell = new Cell(new Paragraph(String.valueOf(paystub.getTax_hi()), font));
		cell.setColspan(2);
		cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.addCell(cell);

		// 복리후생
		cell = new Cell(new Paragraph("복리후생", font));
		cell.setColspan(2);
		cell.setBackgroundColor(Color.lightGray);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.addCell(cell);

		cell = new Cell(new Paragraph(String.valueOf(paystub.getCosts_benefit()), font));
		cell.setColspan(2);
		cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.addCell(cell);

		// 빈칸
		cell = new Cell(new Paragraph("", font));
		cell.setColspan(4);
		cell.setRowspan(2);
		table.addCell(cell);

		// 기타
		cell = new Cell(new Paragraph("기타", font));
		cell.setColspan(2);
		cell.setBackgroundColor(Color.lightGray);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.addCell(cell);

		cell = new Cell(new Paragraph(String.valueOf(paystub.getCosts_etc()), font));
		cell.setColspan(2);
		cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.addCell(cell);

		// 빈칸
		cell = new Cell(new Paragraph("", font));
		cell.setColspan(4);
		table.addCell(cell);

		// 공제합계
		cell = new Cell(new Paragraph("공제합계", font));
		cell.setColspan(2);
		cell.setBackgroundColor(Color.lightGray);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.addCell(cell);

		cell = new Cell(new Paragraph(String.valueOf(paystub.getTax_sum()), font));
		cell.setColspan(2);
		cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.addCell(cell);

		// 급여계
		cell = new Cell(new Paragraph("급여계", font));
		cell.setColspan(2);
		cell.setBackgroundColor(Color.lightGray);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.addCell(cell);

		cell = new Cell(new Paragraph(String.valueOf(paystub.getSalary_sum()), font));
		cell.setColspan(2);
		cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.addCell(cell);

		// 차감수령액
		cell = new Cell(new Paragraph("차감수령액", font));
		cell.setColspan(2);
		cell.setBackgroundColor(Color.lightGray);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.addCell(cell);

		cell = new Cell(new Paragraph(String.valueOf(paystub.getSalary_sum() - paystub.getTax_sum()), font));
		cell.setColspan(2);
		cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.addCell(cell);

		document.add(table);

	}

}
