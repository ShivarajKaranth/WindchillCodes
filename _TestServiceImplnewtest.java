package ext.newspace.test;

import java.io.BufferedReader;
import wt.vc.struct.StructHelper;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import wt.change2.WTChangeIssue;
import wt.change2.WTChangeOrder2;
import wt.fc.PersistenceHelper;
import wt.fc.PersistenceManager;
import wt.fc.PersistenceServerHelper;
import wt.fc.QueryResult;
import wt.fc.ReferenceFactory;
import wt.part.WTPart;
import wt.query.QueryException;
import wt.query.QuerySpec;
import wt.query.SearchCondition;
import wt.series.MultilevelSeries;
import wt.series.Series;
import wt.util.WTException;
import wt.util.WTInvalidParameterException;
import wt.util.WTPropertyVetoException;
import wt.vc.Iterated;
import wt.vc.IterationIdentifier;
import wt.vc.Mastered;
import wt.vc.VersionControlHelper;
import wt.vc.VersionReference;
import wt.vc.config.ConfigSpec;
import wt.vc.views.View;
import wt.vc.views.ViewHelper;
import wt.content.ContentHolder;
import wt.content.ContentHelper;
import wt.content.FormatContentHolder;
import wt.content.ContentItem;
import wt.content.ContentServerHelper;
import wt.content.ApplicationData;
import wt.content.ContentRoleType;
import org.apache.log4j.Logger;
import com.ptc.core.meta.common.TypeIdentifier;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.beans.PropertyVetoException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.rmi.RemoteException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;
import java.util.concurrent.TimeUnit;
import wt.type.TypeDefinitionReference;
import wt.type.TypedUtility;
import wt.inf.container.WTContainer;
import wt.inf.container.WTContainerHelper;
import wt.inf.container.WTContainerRef;
import wt.inf.library.WTLibrary;
import wt.folder.FolderEntry;
import wt.folder.FolderHelper;
import wt.type.ClientTypedUtility;
import com.ptc.core.meta.common.TypeIdentifier;

import org.apache.log4j.Logger;

import com.ptc.core.businessfield.common.BusinessField;
import com.ptc.core.businessfield.common.BusinessFieldIdFactoryHelper;
import com.ptc.core.businessfield.common.BusinessFieldServiceHelper;
import com.ptc.core.businessfield.server.BusinessFieldIdentifier;
import com.ptc.core.businessfield.server.businessObject.BusinessObject;
import com.ptc.core.businessfield.server.businessObject.BusinessObjectHelper;
import com.ptc.core.businessfield.server.businessObject.BusinessObjectHelperFactory;
import com.ptc.core.components.util.FeedbackMessage;
import com.ptc.core.meta.common.UpdateOperationIdentifier;
import com.ptc.windchill.bac.specfile.jaxb.LifeCycleTemplate;
import com.ptc.windchill.cadx.common.util.ObjectDependencyUtility;
import com.ptc.windchill.ws.GenericBusinessObject;


import wt.associativity.EquivalenceLink;
import wt.configurablelink.ConfigurableDescribeLink;
import wt.doc.DocumentType;
import wt.doc.WTDocument;
import wt.doc.WTDocumentDependencyLink;
import wt.doc.WTDocumentMaster;
import wt.epm.EPMAuthoringAppType;
import wt.epm.EPMDocument;
import wt.epm.EPMDocumentMaster;
import wt.epm.EPMDocumentType;
import wt.epm.build.EPMBuildRule;
import wt.epm.structure.EPMDescribeLink;
import wt.epm.structure.EPMReferenceLink;
import wt.epm.workspaces.EPMWorkspace;
import wt.fc.Identified;
import wt.fc.IdentityHelper;
import wt.fc.ObjectIdentifier;
import wt.fc.ObjectReference;
import wt.fc.Persistable;
import wt.fc.PersistenceHelper;
import wt.fc.QueryResult;
import wt.fc.collections.WTArrayList;
import wt.fc.collections.WTCollection;
import wt.fc.collections.WTHashSet;
import wt.fc.collections.WTSet;
import wt.fc.collections.WTValuedMap;
import wt.fc.WTObject;
import wt.folder.Folder;
import wt.folder.FolderHelper;
import wt.lifecycle.LifeCycleHelper;
import wt.lifecycle.State;
import wt.log4j.LogR;
import wt.method.RemoteAccess;
import wt.method.RemoteMethodServer;
import wt.part.WTPart;
import wt.part.WTPartDescribeLink;
import wt.part.WTPartHelper;
import wt.part.WTPartMaster;
import wt.part.WTPartMasterIdentity;
import wt.part.WTPartReferenceLink;
import wt.part.WTPartUsageLink;
import wt.pds.StatementSpec;
import wt.pom.PersistenceException;
import wt.query.SearchCondition;
import wt.session.SessionHelper;
import wt.session.SessionServerHelper;
import wt.team.TeamReference;
import wt.vc.config.ConfigHelper;
import wt.type.TypedUtilityServiceHelper;
import wt.util.WTException;
import wt.vc.VersionIdentifier;
import wt.vc.Versioned;
import wt.vc.views.View;
import wt.vc.views.ViewHelper;
import wt.vc.views.ViewManageable;
import wt.vc.wip.CheckoutLink;
import wt.vc.wip.NonLatestCheckoutException;
import wt.vc.wip.WorkInProgressException;
import wt.vc.wip.WorkInProgressHelper;
import wt.vc.wip.WorkInProgressServerHelper;
import wt.workflow.WfException;
import wt.workflow.engine.WfEngineHelper;
import wt.workflow.engine.WfProcess;
import wt.workflow.engine.WfState;
import wt.workflow.engine.WfTransition;
import wt.workflow.work.WorkItem;
import wt.workflow.work.WorkflowHelper;
import wt.log4j.LogR;
import org.apache.commons.lang.StringUtils;
import org.apache.james.mime4j.util.ContentUtil;

import com.ptc.core.foundation.type.server.impl.TypeHelper;
import com.ptc.core.meta.common.TypeIdentifier;
import com.ptc.core.meta.common.impl.WCTypeIdentifier;





public class _TestServiceImplnewtest implements _TestServicenewtest {



	public boolean replaceAttachment(String string) throws IOException {
		List<String> treeSetnew = new LinkedList();
	    BufferedReader _buffereReader = null;
		try {

			treeSetnew.add("EPMDOCUMENT#EPMDOCUMENT-VERSION#ATTACHMENT#ROLETYPE\n");
			_buffereReader = new BufferedReader(new FileReader(string));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String _data = null;
		try {
			while((_data = _buffereReader.readLine())!= null) {
				String _rowData[] = _data.split(_TestServicenewtest.DELIMITOR);
				String strEpmNumber = _rowData[0];
				String EpmVersion = _rowData[1];
				String Attachment = _rowData[2];
				String roletyp=_rowData[3];
				
				String[] EpmVersionpieces = EpmVersion.split("\\.");
				if (EpmVersionpieces.length != 2 || EpmVersionpieces[0].trim().length() == 0
						|| EpmVersionpieces[1].trim().length() == 0) {
					String err = "Invalid version format, it must match '<revision>.<iteration>': " + EpmVersion;
					// throw new VersionFormatException(err);
				}
				String Epmrev = EpmVersionpieces[0];
				String Epmiter = EpmVersionpieces[1]; 


		int count = 0;
		
		QuerySpec qs = new QuerySpec(EPMDocumentMaster.class);
		SearchCondition sc = new SearchCondition(EPMDocumentMaster.class, EPMDocumentMaster.NUMBER,
				SearchCondition.EQUAL,strEpmNumber,false);
		qs.appendWhere(sc, new int[] { 0, 1 });
		qs.setAdvancedQueryEnabled(true);
		QueryResult qr = PersistenceHelper.manager.find(qs);

		if (qr.hasMoreElements()) {
			EPMDocumentMaster master = (EPMDocumentMaster) qr.nextElement();
            QueryResult qr2 = VersionControlHelper.service.allVersionsOf(master);
		    Object element = null;
				if (qr2.hasMoreElements() && (element = qr2.nextElement()) instanceof EPMDocument) {
					EPMDocument doc = (EPMDocument) element;
					System.out.println("Looking at revision " + doc.getVersionIdentifier().getValue());
					WTCollection collection = new WTArrayList();
					collection.add(doc);
					WTValuedMap latest_map = VersionControlHelper.service.getLatestRevisions(collection);
					Object val = latest_map.get(doc);
					if (val instanceof VersionReference
							&& ((VersionReference) val).getObject() instanceof EPMDocument) {
						EPMDocument any_iteration = (EPMDocument) (((VersionReference) val).getObject());
						System.out.println("The iterations of EPM doc are  " +any_iteration.getIterationIdentifier().getValue());
						Iterated latest_iter = VersionControlHelper.service.getLatestIteration(any_iteration,
								false);
						if (latest_iter instanceof EPMDocument) {
							EPMDocument latest_doc = (EPMDocument) latest_iter;
							System.out.println(
									"Latest iteration is: " +latest_doc.getNumber()+"#"+latest_doc.getVersionIdentifier().getValue()+"." +latest_doc.getIterationIdentifier().getValue());
							
						}
						else {
							System.out
							.println("Could not get the latest iteration of the revision found for cad name"
									+ strEpmNumber);
						}
					
					
					
					ContentHolder holder = (ContentHolder)new ReferenceFactory().getReference(any_iteration).getObject();
					
					holder = wt.content.ContentHelper.service.getContents(holder);
					System.out.println("Referenced docs are : "  +holder.getIdentity());
					

					final QueryResult contents = ContentHelper.service.getContentsByRole(holder,ContentRoleType.SECONDARY);

					while(contents.hasMoreElements()) {

					 ContentItem ci = (ContentItem)contents.nextElement();
					 String secondattachment=null;

					 if(ci instanceof ApplicationData) {
						secondattachment=getAttachmentName(doc);
						
					 }
					}
					
					
					
					System.out.println("Now deleting the attachments");
					
					String deletedcontent=deletecontent(holder,doc,strEpmNumber); 
					                                                                   // Deleting contents
					 //ContentHolder holder = (ContentHolder)new ReferenceFactory().getReference(strEpmNumber).getObject();
					 System.out.println("Now Adding the attachments");
				     holder = wt.content.ContentHelper.service.getContents(holder);
				     String fileName = Attachment;
				     String roletype=roletyp;
				     File attachment = new File("D:/Input_files/Doctoadd/"+fileName);
	            	 String filePath=attachment.getPath();
				     String addedattachments=addAttachments(holder,filePath,fileName,strEpmNumber,roletype);
				     
				     
				     
				}
				else {
					System.out.println(
							"Could not find the latest revision of the master found for cad name: " + strEpmNumber);
				}
		}
				else {
					System.out.println("Not valid revision");
				}
		}               
		
			
			}
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public String getAttachmentName(WTObject obj) throws WTException {
		String name = "";
		try {
	                
	               
				    if(obj != null){
						if (obj instanceof EPMDocument) {
							EPMDocument epm = (EPMDocument) obj;
							QueryResult qr = ContentHelper.service.getContentsByRole(epm, ContentRoleType.SECONDARY);
							while (qr.hasMoreElements()) {
								ApplicationData applicationdata = (ApplicationData) qr.nextElement();
								String filename = applicationdata.getFileName();
								name = name+"   "+ filename;
								}
							System.out.println("Name of attachment is : " +name);
							}
						}
						else {
							System.out.println("object is not instance of EPMDOCUMENT");
						}
				      
				    }
					catch (Exception e) {
			System.out.println("Exception in getting attachments"+e);
		}
		return name;
	}
	
	public String addAttachments(ContentHolder holder, String filePath,String fileName,String strEpmNumber,String roletype) throws WTException {
		try {
			ApplicationData applicationData = ApplicationData.newApplicationData(holder);
            String strEpmNumber1=strEpmNumber;
            String roletype1=roletype;
            String fileName1 = fileName;
     		File attachment = new File("D:/Input_files/Doctoadd/"+fileName1);
     		String Filepath=filePath;
     		//Filepath=attachment.getPath();
     		applicationData.setRole(ContentRoleType.toContentRoleType(roletype1));
     		applicationData = (ApplicationData) PersistenceHelper.manager.save(applicationData);
     		applicationData = ContentServerHelper.service.updateContent(holder, applicationData,Filepath);
     		applicationData.setFileName(fileName1);
     		applicationData.setCategory("General");
     		applicationData = (ApplicationData) PersistenceHelper.manager.modify(applicationData);
     		System.out.println("Added attachment  "  + fileName1 + " successfully to the Document " + strEpmNumber1);	
					}
				 catch (Exception e) {
				  System.out.println("Exception in adding attachments"+e);
				}
		return null;
			
}
	public String deletecontent(ContentHolder holder,EPMDocument doc,String strEpmNumber) throws WTException{
		try {
			String EPMnumber=strEpmNumber; 
			ContentHolder holder1=holder;
			EPMDocument doc1=doc;
			holder1 = (ContentHolder)new ReferenceFactory().getReference(doc1).getObject();
			holder1 = wt.content.ContentHelper.service.getContents(holder1);
            String number1 = doc1.getNumber();
            Vector contents1 = ContentHelper.getContentList(holder1);

            int num_of_files = contents1.size();
            
           
            System.out.println("Removing " + num_of_files + " content items from " + number1);
           
            for (int i = 0; i < num_of_files; i++)

            {
            	

            ContentItem ci = (ContentItem)contents1.elementAt(i);

            System.out.println("Removing content item: " + ci.getDescription());

            ContentServerHelper.service.deleteContent(holder1,ci);

            }
          
		}
		catch(Exception e) {
			System.out.println("Exception in deleting contents"+e);
		}
		return null;
	}
	public boolean createDoc(String string) throws WTException {
		
		System.out.println(">>>>>>> create doc started <<<<<<<<<<");
		List<String> treeSet1 = new LinkedList();
		BufferedReader _buffereReader = null;
		try {
			treeSet1.add("DOCNAME#CONTAINERNAME#FOLDER#TYPE#ATTACHMENT#ROLETYPE#targetst#revision\n");
			_buffereReader = new BufferedReader(new FileReader(string));//reading file from location
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String _data = null;
		try {
			while ((_data = _buffereReader.readLine()) != null) {
				String _rowData[] = _data.split(_TestServicenewtest.DELIMITOR);//Splitting input based on #
				String docName = _rowData[0];//part number
				String containername = _rowData[1];
				String folder = _rowData[2];
				String type = _rowData[3];
				String Attachment=_rowData[4];
				String roletype=_rowData[5];
				String targetstate=_rowData[6];
				String rev=_rowData[7];
				
				
				String container_path="/wt.inf.container.OrgContainer=Demo Organization/wt.pdmlink.PDMLinkProduct=Drive System";
				String folder_path="/Default";
				String lifecycleName="Basic";
				
				
				if (docName == null || "".equals(docName)) {
					return false;
				}
				
				if (containername == null || "".equals(containername)) {
					return false;
				}
				TypeDefinitionReference myCustomTDR=new TypeDefinitionReference();
				
				if(type.equals("Specification Document")) {
				TypeIdentifier myCustomType = (TypeIdentifier) TypeHelper.getTypeIdentifier("WCTYPE|wt.doc.WTDocument|Specification.Document");   // Internal name of sub type specification document 
				WCTypeIdentifier myCustomWCType = (WCTypeIdentifier) myCustomType;
				myCustomTDR = TypedUtilityServiceHelper.service.getTypeDefinitionReference(myCustomWCType.getTypename());
				
				}
				
				else if(type.equals("Reference Document")) {
					TypeIdentifier myCustomType = (TypeIdentifier) TypeHelper.getTypeIdentifier("WCTYPE|wt.doc.WTDocument|com.ptc.ReferenceDocument");   // Internal name of sub type specification document 
					WCTypeIdentifier myCustomWCType = (WCTypeIdentifier) myCustomType;
					myCustomTDR = TypedUtilityServiceHelper.service.getTypeDefinitionReference(myCustomWCType.getTypename());
					
				}
				
				WTDocument document = WTDocument.newWTDocument();
				document.setTypeDefinitionReference(myCustomTDR);
				
				document.setName(docName);
				document.setNumber(docName.toUpperCase());
				
				String docno=document.getNumber();
				WTContainerRef containerRef=WTContainerHelper.service.getByPath(container_path);
				document.setContainerReference(containerRef);
				
				Folder foldr =FolderHelper.service.getFolder(folder_path,containerRef);
				FolderHelper.assignLocation((FolderEntry)document, foldr);
				
				
				VersionIdentifier vc = VersionIdentifier.newVersionIdentifier(MultilevelSeries.newMultilevelSeries("wt.series.HarvardSeries", rev));
		        document.getMaster().setSeries("wt.series.HarvardSeries");
		        VersionControlHelper.setVersionIdentifier(document, vc);
		            // set iteration as "1"
		        Series ser = Series.newSeries("wt.vc.IterationIdentifier", "1");
		        IterationIdentifier iid = IterationIdentifier.newIterationIdentifier(ser);
		        VersionControlHelper.setIterationIdentifier(document, iid);
		        document = (WTDocument) wt.fc.PersistenceHelper.manager.save(document);
		        
		        System.out.println("Document " + docName + " created");
		        System.out.println("Doc name  "  +docName);	
				System.out.println("Container name  "  +containername);	
				System.out.println("Folder  "  +folder);
				System.out.println("Type  "  +type);
		        
		         System.out.println("Now Adding the attachments");
		        ContentHolder holder = (ContentHolder)new ReferenceFactory().getReference(document).getObject();
			    holder = wt.content.ContentHelper.service.getContents(holder);
			    String fileName = Attachment;
			    String roletyp=roletype;
			    File attachmentadd = new File("D:/Input_files/Doctoadd/"+fileName);
           	    String filePath=attachmentadd.getPath();
			    String addedattachments=addAttachments(holder,filePath,fileName,docno,roletyp);
			    System.out.println("Added the attachments");
			    
			    //document = (WTDocument) wt.fc.PersistenceHelper.manager.store(document);
			    
			    setlifecyclestate(document,targetstate);
				System.out.println("Lifecycle state is set to : " +targetstate);
				
				System.out.println("Now revising the document  " );
				String comment="testing revising document";
				reviseWTDocument(document, comment);
				System.out.println("Revised the document successfully  " );
				
			    
				}
		}catch(Exception e){
			System.out.println("Exception" +e);
		}
		
		return false;
}
	
	
	
	public boolean prepareToCreateEPMDoc(String string) throws WTException, WTInvalidParameterException, WTPropertyVetoException {
		
		
		System.out.println(">>>>>>> prepareToCreateEPMDoc started <<<<<<<<<<");
		List<String> treeSet1 = new LinkedList();
		BufferedReader _buffereReader = null;
		try {
			treeSet1.add("WTPARTNUMBER#EPMDOCNUMBER#EPMDOCNAME\n");
			_buffereReader = new BufferedReader(new FileReader(string));//reading file from location
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String _data = null;
		try {
			while ((_data = _buffereReader.readLine()) != null) {
				String _rowData[] = _data.split(_TestServicenewtest.DELIMITOR);//Splitting input based on #
				String wtPartNumber = _rowData[0];//part number
				String epmDocnumber = _rowData[1];
				String epmDocname = _rowData[2];
				String epmDocFileName = epmDocname + ".prt";
        
                EPMAuthoringAppType authoringApplication = EPMAuthoringAppType.toEPMAuthoringAppType("PROE");

                System.out.println("*************createEPMDoc*************: Start");
                
       wt.part.WTPart object = new wt.part.WTPart();
      // object.getNumber();//getWTPart gets me WTPart object that already exist in my system
       EPMDocumentType epmDocumentType = EPMDocumentType.getEPMDocumentTypeDefault();
        
        //get WTContainerRef from wtpart. New EPMDoc will be created in this WTContainerRef
       //WTContainerRef epmContainerReference = wtpart.getContainerReference();
       String container_path="/wt.inf.container.OrgContainer=Demo Organization/wt.pdmlink.PDMLinkProduct=Drive System";
	   String folder_path="/Default";
       
       WTContainerRef epmContainerReference=WTContainerHelper.service.getByPath(container_path);
	   
       
       
        
        //get Folder from wtpart. New EPMDoc will be created in this Folder
        //Folder epmFolder = FolderHelper.service.getFolder((FolderEntry)wtpart);
       
       Folder epmFolder =FolderHelper.service.getFolder(folder_path,epmContainerReference);
	   //FolderHelper.assignLocation((FolderEntry)document, epmFolder);
       
        
        ///create EPMDoc object
        EPMDocument epmdoc=createEPMDoc(epmDocnumber, epmDocname, authoringApplication, epmDocumentType, epmDocFileName,
                epmContainerReference, epmFolder);
        
        System.out.println("*************createEPMDoc*************: Finish");
        System.out.println("Now revising the EPM DOCUMENT");
        String comment="Testing revising";
        reviseEPMDocument(epmdoc,comment);
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception"+e);
		}
		
        return false;
    }
	
	
	
	
	
	
	
	
	public EPMDocument createEPMDoc(String epmDocnumber, String epmDocname,
            EPMAuthoringAppType authoringApplication,
            EPMDocumentType epmDocumentType, String epmDocFileName,
            WTContainerRef epmContainerReference, Folder epmFolder)
                    throws WTInvalidParameterException, WTPropertyVetoException, WTException {
        wt.epm.EPMContextHelper.setApplication(wt.epm.EPMApplicationType.toEPMApplicationType("EPM"));



       //create EPMDocument object
        EPMDocument EPMDoc = EPMDocument.newEPMDocument(epmDocnumber, epmDocname, authoringApplication,
                EPMDocumentType.getEPMDocumentTypeDefault(), epmDocFileName);



       //set container ref for EPMDoc
        EPMDoc.setContainerReference(epmContainerReference);
        
        //get folder ref for EPMDoc
        FolderHelper.assignLocation((wt.folder.FolderEntry) EPMDoc, epmFolder);



       //persist epmDoc object in database
        PersistenceHelper.manager.save(EPMDoc);
        return EPMDoc;
    }
	
	public static WTDocument reviseWTDocument(WTDocument document, String comment) throws WTException {
       
                  WTDocument wtdocument = document;
                    try {
                            if (wtdocument == null) {
                                return null;
                            }
                            WTContainer container = wtdocument.getContainer();
                            WTContainerRef containerRef = WTContainerRef.newWTContainerRef(container); // container.getContainerReference();//
                            TeamReference teamReference = wtdocument.getTeamId();
                            Folder oldFoler = FolderHelper.getFolder(wtdocument);
                            if (oldFoler == null) {
                                String strLocation = wtdocument.getLocation();
                                oldFoler = FolderHelper.service.getFolder(strLocation, containerRef);
                            }
                                wtdocument = (WTDocument) wt.vc.VersionControlHelper.service.newVersion((wt.vc.Versioned) wtdocument);
                                if (teamReference != null) {
                                    wtdocument.setTeamId(teamReference);
                                }
                                VersionControlHelper.setNote(wtdocument, comment == null ? "" : comment);
                                wtdocument.setContainer(container);
                            FolderHelper.assignLocation((FolderEntry) wtdocument, oldFoler);
                            wtdocument = (WTDocument) PersistenceHelper.manager.save(wtdocument);
                            wtdocument = (WTDocument) PersistenceHelper.manager.refresh(wtdocument);
                    } 
                    
               
        catch (Exception e) {
           System.out.println("Exception"+e);
        }
       return wtdocument;
       
}
	
	
	public static EPMDocument reviseEPMDocument(EPMDocument document, String comment) throws WTException {
	       
		EPMDocument epmdocument = document;
          try {
                  if (epmdocument == null) {
                      return null;
                  }
                  WTContainer container = epmdocument.getContainer();
                  WTContainerRef containerRef = WTContainerRef.newWTContainerRef(container); // container.getContainerReference();//
                  TeamReference teamReference = epmdocument.getTeamId();
                  Folder oldFoler = FolderHelper.getFolder(epmdocument);
                  if (oldFoler == null) {
                      String strLocation = epmdocument.getLocation();
                      oldFoler = FolderHelper.service.getFolder(strLocation, containerRef);
                  }
                  epmdocument = (EPMDocument) wt.vc.VersionControlHelper.service.newVersion((wt.vc.Versioned) epmdocument);
                      if (teamReference != null) {
                    	  epmdocument.setTeamId(teamReference);
                      }
                      VersionControlHelper.setNote(epmdocument, comment == null ? "" : comment);
                      epmdocument.setContainer(container);
                  FolderHelper.assignLocation((FolderEntry) epmdocument, oldFoler);
                  epmdocument = (EPMDocument) PersistenceHelper.manager.save(epmdocument);
                  epmdocument = (EPMDocument) PersistenceHelper.manager.refresh(epmdocument);
          } 
          
     
catch (Exception e) {
 System.out.println("Exception"+e);
}
return epmdocument;

}
	/*public boolean createreferenceLink(WTPart part,WTDocument document) throws WorkInProgressException, WTPropertyVetoException, PersistenceException, WTException {
		try {
		    
            Folder checkoutFolder1 = WorkInProgressHelper.service.getCheckoutFolder();
	        CheckoutLink col1 = WorkInProgressHelper.service.checkout(part,checkoutFolder1,"");
	        part = (WTPart)col1.getWorkingCopy();

	        //Creating Link between part and doc
	        WTPartDescribeLink link=WTPartDescribeLink.newWTPartDescribeLink(part, document);
	        PersistenceHelper.manager.save(link);
	        System.out.println("Link created between document and part  ");

	        part = (WTPart)WorkInProgressHelper.service.checkin(part,"");
		}
		catch(Exception e)
		{
			System.out.println("Exception"+e);
		}
		return false;
	}*/
	
	/*public boolean linkcreation(String string) throws WTException{
		
		System.out.println(">>>>>>> Link creation started <<<<<<<<<<");
		List<String> treeSet1 = new LinkedList();
		BufferedReader _buffereReader = null;
		try {
			treeSet1.add("PARTNUMBER#DOCNUMBER\n");
			_buffereReader = new BufferedReader(new FileReader(string));//reading file from location
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String _data = null;
		try {
			while ((_data = _buffereReader.readLine()) != null) {
				String _rowData[] = _data.split(_TestServicenewtest.DELIMITOR);//Splitting input based on #
				String partNumber = _rowData[0];//part number
				String docNumber = _rowData[1];
				WTPart part=null;
		        WTDocument doc=null;
		        //String number="0000000025";
		        //String docnumber="0000000027";
		        QuerySpec qspec=new QuerySpec(WTPart.class);
		        qspec.appendWhere(new SearchCondition(WTPart.class,WTPart.NUMBER,SearchCondition.LIKE,partNumber),new int[]{0,1});
		        QueryResult qr=PersistenceHelper.manager.find((StatementSpec)qspec);
		        while(qr.hasMoreElements())
		        {
		            part=(WTPart) qr.nextElement();
		        }
		        System.out.println("Part found");

		        QuerySpec qspec1=new QuerySpec(WTDocument.class);
		        qspec1.appendWhere(new SearchCondition(WTDocument.class,WTDocument.NUMBER,SearchCondition.LIKE,docNumber),new int[]{0,1});
		        QueryResult qr1=PersistenceHelper.manager.find((StatementSpec)qspec1);
		        while(qr1.hasMoreElements())
		        {
		            doc=(WTDocument) qr1.nextElement();
		        }
		        System.out.println("Document found");
		        System.out.println("Now creating reference link between document and part");
				createreferenceLink(part,doc);
				System.out.println("Reference link created successfully");
				
	}
		}
		catch(Exception e) {
			System.out.println("Exception"+e);
		}
		return false;
	}*/
	
	
	
	public boolean createreferencedocLink(WTPart part,WTDocumentMaster document) throws WorkInProgressException, WTPropertyVetoException, PersistenceException, WTException {
		try {
		    

	        Folder checkoutFolder1 = WorkInProgressHelper.service.getCheckoutFolder();
	        CheckoutLink col1 = WorkInProgressHelper.service.checkout(part,checkoutFolder1,"");
	        part = (WTPart)col1.getWorkingCopy();

	        //Creating Link between part and doc
	        WTPartReferenceLink link=WTPartReferenceLink.newWTPartReferenceLink(part,document);
	        PersistenceHelper.manager.save(link);
	        

	        part = (WTPart)WorkInProgressHelper.service.checkin(part,"");
            System.out.println("Link created between document and part  ");
            
            }
		catch(Exception e)
		{
			System.out.println("Exception"+e);
		}
		return false;
	}
	
	
public boolean reflinkcreation(String string) throws WTException{
		
		System.out.println(">>>>>>> refLink creation started <<<<<<<<<<");
		List<String> treeSet1 = new LinkedList();
		BufferedReader _buffereReader = null;
		try {
			treeSet1.add("PARTNUMBER#DOCNUMBER\n");
			_buffereReader = new BufferedReader(new FileReader(string));//reading file from location
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String _data = null;
		try {
			while ((_data = _buffereReader.readLine()) != null) {
				String _rowData[] = _data.split(_TestServicenewtest.DELIMITOR);//Splitting input based on #
				String partNumber = _rowData[0];//part number
				String docNumber = _rowData[1];
				WTPart part=null;
		        WTDocumentMaster doc=null;
		        //String number="0000000025";
		        //String docnumber="0000000027";
		        QuerySpec qspec=new QuerySpec(WTPart.class);
		        qspec.appendWhere(new SearchCondition(WTPart.class,WTPart.NUMBER,SearchCondition.LIKE,partNumber),new int[]{0,1});
		        QueryResult qr=PersistenceHelper.manager.find((StatementSpec)qspec);
		        while(qr.hasMoreElements())
		        {
		            part=(WTPart) qr.nextElement();
		        }
		        System.out.println("Part found");

		        QuerySpec qspec1=new QuerySpec(WTDocumentMaster.class);
		        qspec1.appendWhere(new SearchCondition(WTDocumentMaster.class,WTDocumentMaster.NUMBER,SearchCondition.LIKE,docNumber),new int[]{0,1});
		        QueryResult qr1=PersistenceHelper.manager.find((StatementSpec)qspec1);
		        while(qr1.hasMoreElements())
		        {
		            doc=(WTDocumentMaster) qr1.nextElement();
		        }
		        System.out.println("Document found");
		        System.out.println("Now creating reference link between document and part");
				createreferencedocLink(part,doc);
				System.out.println("Reference link created successfully");
				
	}
		}
		catch(Exception e) {
			System.out.println("Exception"+e);
		}
		return false;
	}



public boolean createreferenceEPMdocLink(WTPart part,EPMDocument document) throws WorkInProgressException, WTPropertyVetoException, PersistenceException, WTException {
	try {
	    

        Folder checkoutFolder1 = WorkInProgressHelper.service.getCheckoutFolder();
        CheckoutLink col1 = WorkInProgressHelper.service.checkout(part,checkoutFolder1,"");
        part = (WTPart)col1.getWorkingCopy();

        //Creating Link between part and doc
        EPMBuildRule link=EPMBuildRule.newEPMBuildRule(document,part,EPMBuildRule.BUILD_ATTRIBUTES | EPMBuildRule.CAD_REPRESENTATION);
        
        
      
        PersistenceHelper.manager.save(link);
        System.out.println("Link created between document and part  ");

        part = (WTPart)WorkInProgressHelper.service.checkin(part,"");
        System.out.println("Link created between document and part  ");
        
        }
	catch(Exception e)
	{
		System.out.println("Exception"+e);
	}
	return false;
}


public boolean epmreflinkcreation(String string) throws WTException{
	
	System.out.println(">>>>>>> epmrefLink creation started <<<<<<<<<<");
	List<String> treeSet1 = new LinkedList();
	BufferedReader _buffereReader = null;
	try {
		treeSet1.add("PARTNUMBER#EPMDOCNUMBER\n");
		_buffereReader = new BufferedReader(new FileReader(string));//reading file from location
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	String _data = null;
	try {
		while ((_data = _buffereReader.readLine()) != null) {
			String _rowData[] = _data.split(_TestServicenewtest.DELIMITOR);//Splitting input based on #
			String partNumber = _rowData[0];//part number
			String epmdocNumber = _rowData[1];
			WTPart part=null;
	        EPMDocument doc=null;
	        //String number="0000000025";
	        //String docnumber="0000000027";
	        QuerySpec qspec=new QuerySpec(WTPart.class);
	        qspec.appendWhere(new SearchCondition(WTPart.class,WTPart.NUMBER,SearchCondition.LIKE,partNumber),new int[]{0,1});
	        QueryResult qr=PersistenceHelper.manager.find((StatementSpec)qspec);
	        while(qr.hasMoreElements())
	        {
	            part=(WTPart) qr.nextElement();
	        }
	        System.out.println("Part found");

	        QuerySpec qspec1=new QuerySpec(EPMDocument.class);
	        qspec1.appendWhere(new SearchCondition(EPMDocument.class,EPMDocument.NUMBER,SearchCondition.LIKE,epmdocNumber),new int[]{0,1});
	        QueryResult qr1=PersistenceHelper.manager.find((StatementSpec)qspec1);
	        while(qr1.hasMoreElements())
	        {
	            doc=(EPMDocument) qr1.nextElement();
	        }
	        System.out.println("EPM Document found");
	        System.out.println("Now creating reference link between document and part");
	        createreferenceEPMdocLink(part,doc);
			System.out.println("Reference link created successfully");
			
}
	}
	catch(Exception e) {
		System.out.println("Exception"+e);
	}
	return false;
}
	

public boolean wtreflinkdeletion(String string) throws WTException {
	
	System.out.println(">>>>>>> wtrefLink deletion started <<<<<<<<<<");
	List<String> treeSet1 = new LinkedList();
	BufferedReader _buffereReader = null;
	try {
		treeSet1.add("PARTNUMBER#DOCNUMBER\n");
		_buffereReader = new BufferedReader(new FileReader(string));//reading file from location
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	String _data = null;
	try {
		while ((_data = _buffereReader.readLine()) != null) {
			String _rowData[] = _data.split(_TestServicenewtest.DELIMITOR);//Splitting input based on #
			String partNumber = _rowData[0];//part number
			String docNumber = _rowData[1];
			WTPart part=null;
			WTDocument wtdoc=null;
			
			 QuerySpec qspec=new QuerySpec(WTPart.class);
		      qspec.appendWhere(new SearchCondition(WTPart.class,WTPart.NUMBER,SearchCondition.LIKE,partNumber),new int[]{0,1});
		        QueryResult qr=PersistenceHelper.manager.find((StatementSpec)qspec);
		        while(qr.hasMoreElements())
		        {
		        	part=(WTPart) qr.nextElement();
		        }
		        System.out.println("Part found");
			
			
			QuerySpec qspec1=new QuerySpec(WTDocument.class);
		    qspec1.appendWhere(new SearchCondition(WTDocument.class,WTDocument.NUMBER,SearchCondition.LIKE,docNumber),new int[]{0,1});
		    QueryResult qr1=PersistenceHelper.manager.find((StatementSpec)qspec1);
		    while(qr1.hasMoreElements())
		     {
		    	wtdoc=(WTDocument) qr1.nextElement();
		     }
		        System.out.println("WT Document found");
		        
		       
		        System.out.println("Now Removing link");
		        
		        
		        removeReferenceDoc(part,wtdoc);
		        
		       // removeUsageLink(part);
		        
		        System.out.println("Removed the dependency links");
		        
		        
		      }
	}
	catch(Exception e)
	{
		System.out.println("Exception"+e);
	}
	return false;
}






public boolean epmlinkdeletion(String string) throws WTException {
	
	System.out.println(">>>>>>> epmlink deletion started <<<<<<<<<<");
	List<String> treeSet1 = new LinkedList();
	BufferedReader _buffereReader = null;
	try {
		treeSet1.add("PARTNUMBER#EPMDOCNUMBER\n");
		_buffereReader = new BufferedReader(new FileReader(string));//reading file from location
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	String _data = null;
	try {
		while ((_data = _buffereReader.readLine()) != null) {
			String _rowData[] = _data.split(_TestServicenewtest.DELIMITOR);//Splitting input based on #
			String partNumber = _rowData[0];
			String partVersion = _rowData[1];
		    String epmdocNumber = _rowData[2];
			WTPart part=null;
			EPMDocument epmdoc=null;
			
			String[] partVersionpieces = partVersion.split("\\.");
			if (partVersionpieces.length != 2 || partVersionpieces[0].trim().length() == 0
					|| partVersionpieces[1].trim().length() == 0) {
				String err = "Invalid version format, it must match '<revision>.<iteration>': " + partVersion;
				// throw new VersionFormatException(err);
			}
			String partrev = partVersionpieces[0];
			String partiter = partVersionpieces[1];
			
			
			
			QuerySpec qspec1=new QuerySpec(EPMDocument.class);
		    qspec1.appendWhere(new SearchCondition(EPMDocument.class,EPMDocument.NUMBER,SearchCondition.LIKE,epmdocNumber),new int[]{0,1});
		    QueryResult qr1=PersistenceHelper.manager.find((StatementSpec)qspec1);
		    while(qr1.hasMoreElements())
		     {
		    	epmdoc=(EPMDocument) qr1.nextElement();
		     }
		        System.out.println("EPM Document found");
			
			
			
			 QuerySpec qspec=new QuerySpec(WTPart.class);
		     qspec.appendWhere(new SearchCondition(WTPart.class,WTPart.NUMBER,SearchCondition.LIKE,partNumber),new int[]{0,1});
		     QueryResult qr=PersistenceHelper.manager.find((StatementSpec)qspec);
		        
		        
		        
		        while(qr.hasMoreElements())
		       {
		        	part=(WTPart) qr.nextElement();
		        	
		       }
		        	System.out.println("Looking at revision " + part.getVersionIdentifier().getValue());
					WTCollection collection = new WTArrayList();
					collection.add(part);
					WTValuedMap latest_map = VersionControlHelper.service.getLatestRevisions(collection);
					Object val = latest_map.get(part);
					
					
					WTPart any_iteration = (WTPart) (((VersionReference) val).getObject());
					Iterated latest_iter = VersionControlHelper.service.getLatestIteration(any_iteration,false);
					WTPart latest_part = (WTPart) latest_iter;
					
					
					//if (val instanceof VersionReference && ((VersionReference) val).getObject() instanceof WTPart) {
						
						System.out.println("The iterations of part are  " +any_iteration.getIterationIdentifier().getValue());
						
						
						if (latest_iter instanceof WTPart) {
							
							System.out.println("Latest iteration is: " +latest_part.getNumber()+"#"+latest_part.getVersionIdentifier().getValue()+"." +latest_part.getIterationIdentifier().getValue());
							String latestpartnew=latest_part.getVersionIdentifier().getValue();
						    String latestprtnum=latest_part.getNumber();
						    
						    
						}
						
						
					//}
					try {
					Folder checkoutFolder1 = WorkInProgressHelper.service.getCheckoutFolder();
				    CheckoutLink col1 = WorkInProgressHelper.service.checkout(latest_part,checkoutFolder1,"");
				    latest_part = (WTPart)col1.getWorkingCopy();
				    System.out.println("Now Removing link");
			        
			        disassociate(epmdoc, true, true);
		        
			        latest_part = (WTPart)WorkInProgressHelper.service.checkin(latest_part,"");
					}catch(Exception e)		
					{
						System.out.println("Exception"+e);
					}
			        
			        //if(partNumber.equals(latestprtnum)&& partrev.equals(latestpartnew)&&partiter.equals(latest_iter)) {
						    
						    
								
								
						        //}
							
		}
}
	catch(Exception e)
	{
		        	System.out.println("Exception"+e);
	}
	return false;
}




void disassociate(EPMDocument doc, boolean active, boolean passive) throws WTException, WTPropertyVetoException,WorkInProgressException,PersistenceException
{
	
	
	System.out.println("1");
    WTCollection links = new WTArrayList();

    if (active) // find active links
    {
    	System.out.println("2");
        QueryResult br_qr = PersistenceHelper.manager.navigate(doc, EPMBuildRule.BUILD_TARGET_ROLE, EPMBuildRule.class, false);
        System.out.println("Assosiated links"+br_qr.nextElement());
        while (br_qr.hasMoreElements())
       {
        	System.out.println("3");
           // links.add(br_qr.nextElement());
            EPMBuildRule buildRule = (EPMBuildRule) (br_qr.nextElement());
            EPMDocument epmDoc1 = (EPMDocument) buildRule.getRoleAObject();
            System.out.println("epm doc values  "  +epmDoc1.getNumber());
            PersistenceHelper.manager.delete(buildRule);
            
        }
    }

    if (passive) // find passive links
    {
    	System.out.println("4");
        QueryResult dl_qr = PersistenceHelper.manager.navigate(doc, EPMDescribeLink.DESCRIBES_ROLE, EPMDescribeLink.class, false);
       while (dl_qr.hasMoreElements())
        {
    	   System.out.println("5");
           // links.add(dl_qr.nextElement());
            EPMBuildRule buildRule1 = (EPMBuildRule) (dl_qr.nextElement());
            EPMDocument epmDoc2 = (EPMDocument) buildRule1.getRoleAObject();
            System.out.println("epm doc values  " +epmDoc2.getNumber());
            PersistenceHelper.manager.delete(buildRule1);
        }
    }
    
    System.out.println("6");
    
    // delete the links
   
    
    
    
}








	


public static void removeDependencyLink(WTDocument doc) throws WTException {
	try {
		 
		QuerySpec queryspec = new QuerySpec(WTDocumentDependencyLink.class);
		queryspec.appendWhere( new SearchCondition(WTDocumentDependencyLink.class,"roleAObjectRef.key", "=", PersistenceHelper.getObjectIdentifier(doc)), new int[] { 0 });
		QueryResult qr = PersistenceServerHelper.manager.query(queryspec);
		while (qr.hasMoreElements()){
						WTDocumentDependencyLink link = (WTDocumentDependencyLink) qr.nextElement();
						PersistenceServerHelper.manager.remove(link);
					               }
				 
		}
	catch (Exception e) {
		System.out.println("Exception" +e);
	} 
}




public boolean removeReferenceDoc(WTPart part, WTDocument doc) throws WTException{
	try {
		   
		    String docnum=null;
		    docnum=doc.getNumber();
		    part.getVersionIdentifier().getValue();
		    
		    
		    
		    WTCollection collection = new WTArrayList();
			collection.add(part);
			WTValuedMap latest_map = VersionControlHelper.service.getLatestRevisions(collection);
			Object val = latest_map.get(part);
                                 if (val instanceof VersionReference && ((VersionReference) val).getObject() instanceof WTPart) {                
				WTPart any_iteration = (WTPart) (((VersionReference) val).getObject());
				System.out.println("The iterations of WT Part are  " +any_iteration.getIterationIdentifier().getValue());
				Iterated latest_iter = VersionControlHelper.service.getLatestIteration(any_iteration,
						false);
			
				if (latest_iter instanceof WTPart) {
					WTPart latest_part = (WTPart) latest_iter;
					System.out.println("Latest iteration is: " +latest_part.getNumber()+"#"+latest_part.getVersionIdentifier().getValue()+"." +latest_part.getIterationIdentifier().getValue());
				
					
					
					Folder checkoutFolder1 = WorkInProgressHelper.service.getCheckoutFolder();
			        CheckoutLink col1 = WorkInProgressHelper.service.checkout(latest_part,checkoutFolder1,"");
			        latest_part = (WTPart)col1.getWorkingCopy();
					
				
		    QueryResult qr = PersistenceHelper.manager.navigate(latest_part, WTPartReferenceLink.REFERENCES_ROLE, WTPartReferenceLink.class, false);
		   
		    Object element=null;
			try {
				while (qr.hasMoreElements()) {
					
					WTPartReferenceLink link = (WTPartReferenceLink) qr.nextElement();
					if (link!=null) {
						WTPart p = link.getReferencedBy();
						WTDocumentMaster master=link.getReferences();
						//WTDocument d=(WTDocument) element;
					
						//System.out.println("Version is : " +d.getVersionIdentifier().getValue());
				
						if (latest_part.getNumber().equals(p.getNumber()) && doc.getNumber().equals(docnum)) {
							
							
							
							
							PersistenceHelper.manager.delete(link);
							
							//PersistenceServerHelper.manager.update(latest_part);
							
							
							
							
						}
					}
			}
				
			latest_part = (WTPart)WorkInProgressHelper.service.checkin(latest_part,"");
			
			} catch (Exception e) {
				System.out.println("Exception" +e);
			} 
		}
                                 }
            }
	catch (Exception e) {
    	System.out.println("Exception" +e);
	}
	return false;
}

public static WTPart removeUsageLink(WTPart part) throws WTException, WTPropertyVetoException {

    try {
    	
    	part.getVersionIdentifier().getValue();
    	part.getIterationIdentifier().getValue();
    	
    	Iterated latest_iter = VersionControlHelper.service.getLatestIteration(part,false);
    	PersistenceServerHelper.manager.update(part);
    	
        QueryResult qr = WTPartHelper.service.getUsesWTParts(part,WTPartHelper.service.findWTPartConfigSpec());
        
        Folder checkoutFolder1 = WorkInProgressHelper.service.getCheckoutFolder();
        CheckoutLink col1 = WorkInProgressHelper.service.checkout(part,checkoutFolder1,"");
        part = (WTPart)col1.getWorkingCopy();


        while (qr.hasMoreElements()) {

            Object[] obj = (Object[]) qr.nextElement();

            WTPartUsageLink usagelink = (WTPartUsageLink) obj[0];

            PersistenceServerHelper.manager.remove(usagelink);

        }

        PersistenceServerHelper.manager.update(part);
        part = (WTPart)WorkInProgressHelper.service.checkin(part,"");

    } catch (WTException e) {

        e.printStackTrace();

    }

    

    return part;

}


	

	
	
	
	public void setlifecyclestate(WTDocument document,String targetstate) throws WTException {
		try {
		WTDocument doc1=document;
		String mystate=targetstate;
		//String mystate = "RELEASED";
		LifeCycleHelper.service.setLifeCycleState((wt.lifecycle.LifeCycleManaged) doc1, State.toState(mystate));
		//document = (WTDocument) wt.fc.PersistenceHelper.manager.save(doc1); 
		}
		catch(WTException e)
		{
			System.out.println("WTException" +e);
		}
		//return true;
		}
	
	
	public Folder getFolder(WTContainerRef containerRef, String path){
    	Folder folder = null;
		//boolean enforce = SessionServerHelper.manager.setAccessEnforced(false);
		String folderPath = path;
		try {
			if (containerRef == null && folderPath == null) {
				return null;
			}
			if (!(folderPath.startsWith("/"))) {
		    	folderPath = "/" + folderPath;
		    }
		    if (folderPath.indexOf("Default") == -1) {
		    	folderPath = "/Default" + folderPath;
		    }
			folder = (Folder) FolderHelper.service.getFolder(folderPath, containerRef);
		} catch(WTException e) {
			if(folder != null) {
				folder = null;
			}
		} finally {
		    System.out.println("End of getfolder method");
		}
		return folder;
    }
	public WTContainer getWtContainerByName(String name)throws WTException {
        WTContainer obj = null;
 try {
	 System.out.println("getwtContainer");
		 if(StringUtils.isEmpty(name)){
			 System.out.println("inner loop");
			 QuerySpec qs = new QuerySpec(WTContainer.class);
			 SearchCondition sc = new SearchCondition(WTContainer.class, WTContainer.NAME, "=", name);
			 qs.appendWhere(sc);
			 QueryResult qr = PersistenceHelper.manager.find(qs);
			 while (qr.hasMoreElements()) {
				 obj = (WTContainer) qr.nextElement();
				 System.out.println("obj: "+obj.getContainerName().toString());
			 }
		 }
		} catch (Exception e) {
			System.out.println("Exception in getting Container name"+e);
		} finally {
			System.out.println("End of getting container name method");
		}
		return obj;
	}
	
	
}
	
	
	