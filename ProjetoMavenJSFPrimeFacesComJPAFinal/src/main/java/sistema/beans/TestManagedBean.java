package sistema.beans;




import sistema.modelos.Contents;
import sistema.modelos.Choice;
import sistema.modelos.Questions;
import sistema.modelos.Test;
import sistema.modelos.TrueOrFalse;
import sistema.service.ContentService;
import sistema.service.QuestionService;
import sistema.service.TestService;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.ReorderEvent;
import org.primefaces.event.RowEditEvent;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;


@ManagedBean(name="testManagedBean")
@ViewScoped

public class TestManagedBean 
{
	
	private Test test = new Test();
	private List<Test> lstTests;
	private TestService tService = new TestService();
	private Questions question;
	private List<Questions> lstQuestions;
	private ContentService cService = new ContentService();
	private QuestionService qService = new QuestionService();
	private Contents content;
	private List<Contents> lstContents;
	private List<Contents> lstContentsSelected;	
	
	public void save(){
		List<Questions> lstSelecteds = qService.getAllQuestions();
		int cont = 0;
		
		for(int i = 0; i < lstSelecteds.size(); i++){		
			if(lstSelecteds.get(i) .getLevel() <= lstSelecteds.get(i).getLevel() || cont < test.getCountQuestions()){
				test.addQuestion(lstSelecteds.get(i));
				cont++;
			}			
		}
		if(test.getLstQuestions().size() < test.getCountQuestions() && lstSelecteds.size() >= test.getCountQuestions())
		{
			int falta = 0;
			
			falta = test.getCountQuestions() - test.getLstQuestions().size();
			
			for(int i = 0; i < falta; i++){
				if(lstSelecteds.get(i).getLevel() > test.getLevelTest()){
					test.addQuestion(lstSelecteds.get(i));
				}
			}
		}
		
		for(int i = 0; i < lstContentsSelected.size(); i++)			
 			test.addContent(lstContentsSelected.get(i));
  		
		test = tService.save(test);
		if (lstTests != null)
			lstTests.add(test);
		test = new Test();
	}
	@SuppressWarnings("deprecation")
	public void generateTest() {		
        Document document = new Document();
        StringBuilder stringContents = new StringBuilder();
       	        
        try {           
        	 PdfWriter.getInstance(document, 
        		        new FileOutputStream("C:\\Users\\M\\Desktop\\"+ test.getIdTest()+"-"+test.getNameTest()+".pdf"));
        	 document.open();
           
            /*for(int i = 0; i < test.getLstContents().size(); i++){
         	   if(test.getLstContents().size() == 1){
         		  stringContents += test.getLstContents().get(i).getName();
        	   }
         	   else{
         		  stringContents += test.getLstContents().get(i).getName() + ", ";
         	   }
            } */
            test.getLstContents().forEach(x -> stringContents.append(x.getName()).append(", "));
            String strinContent = stringContents.toString().substring(0, stringContents.toString().length() - 2 );
            
            //C:\Users\M\workspace
            Image img = Image.getInstance("C:\\Users\\M\\workspace\\alien.jpg");
            document.add(img);
            
            document.add(Chunk.NEWLINE);            
            
            Paragraph colleague = new Paragraph("Colleague: " + test.getNameColleague());
            colleague.setAlignment(Element.ALIGN_CENTER);
            document.add(colleague);
            
            Paragraph classe = new Paragraph("Class: " + test.getNameClass());
            classe.setAlignment(Element.ALIGN_CENTER);
            document.add(classe);
            
            Paragraph course = new Paragraph("Course: " + test.getCourse());
            course.setAlignment(Element.ALIGN_CENTER);
            document.add(course);
            
            SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            String date = df.format(test.getTestDate());
            
            Paragraph data = new Paragraph("Test Date: " + date);
            data.setAlignment(Element.ALIGN_CENTER);
            document.add(data);
            
            Paragraph contents = new Paragraph("Contents: " + strinContent); //stringContents.toString());
            contents.setAlignment(Element.ALIGN_CENTER);
            document.add(contents);
            
            document.add(Chunk.NEWLINE);
            document.add(Chunk.NEWLINE);
            
            for(int i = 0; i < test.getLstQuestions().size(); i++){
         	   		document.add(new Paragraph(""+(i + 1)+") " + test.getLstQuestions().get(i).getHeader()));
         	   		document.add(new Paragraph(""+ "Minimum Estimated Time: "+  test.getLstQuestions().get(i).getAnswerTime() +", Test Level: " + 
         	   				test.getLstQuestions().get(i).getLevel()));
         	   		document.add( Chunk.NEWLINE );
         	   		
         	   if(test.getLstQuestions().get(i) instanceof Choice){
         	   	  Choice chc = (Choice)test.getLstQuestions().get(i);
     
         		int cont = 1;
         	   	for(int j = 0; j < 5; j++){
         			   document.add(new Paragraph(""+ cont + ") "+ chc.getLstChoices().get(j)));
         			   cont++;
         			   document.add( Chunk.NEWLINE );
         		   }
         		  
         	   }
         	   else if(test.getLstQuestions().get(i) instanceof TrueOrFalse)
         	   {
         		  TrueOrFalse tof = (TrueOrFalse)test.getLstQuestions().get(i);
           			int cont = 1;
           			for(int j = 0; j < 5; j++)
           				{
           					document.add(new Paragraph(""+ cont + ") "+"(  )" + tof.getLstOptions().get(j)));
           					cont++;
           					document.add( Chunk.NEWLINE );
           				}
         	   }      	   
         	   		
         		   document.add(new Paragraph("Answer:"));
         		   document.add(Chunk.NEWLINE);
        		   document.add(Chunk.NEWLINE);
         		   document.add(Chunk.NEWLINE);
            }
            
        }
        catch(DocumentException de) {
            System.err.println(de.getMessage());
            }
        catch(IOException ioe) {
            System.err.println(ioe.getMessage());
        }
        document.close();
    }   
	
	
	
	public List<Test> getLstTests() {
		if (lstTests == null)
			lstTests = tService.getAllTests();
		return lstTests;
	}
	
	
	
	public List<Questions> getLstQuestions(){
		if(lstQuestions == null)
			return qService.getAllQuestions();
		return lstQuestions;
	}
	
	public List<Contents> getLstContents() {
		if(lstContents == null)
			lstContents = cService.getContents();
		return lstContents;
	}	
	
	public Test getTest() {
		return test;
	}
	public void setTest(Test test) {
		this.test = test;
	}
	public Questions getQuestion() {
		return question;
	}
	public void setQuestion(Questions question) {
		this.question = question;
	}
	public void setLstQuestions(List<Questions> lstQuestions) {
		this.lstQuestions = lstQuestions;
	}
	public Contents getContent() {
		return content;
	}
	public void setContent(Contents content) {
		this.content = content;
	}
	
	public List<Contents> getLstContentsSelected() {
		return lstContentsSelected;
	}
	public void setLstContentsSelected(List<Contents> lstContentsSelected) {
		this.lstContentsSelected = lstContentsSelected;
	}
	public void remove(Test test) {
		tService.remove(test);
		lstTests.remove(test);
	}
	public void onRowEdit(RowEditEvent event) {
		Test t = ((Test) event.getObject());
		tService.changeTest(t);
	}
	
	public void onRowReorder(ReorderEvent event) {
        FacesMessage msg = new FacesMessage();
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
	
	
}