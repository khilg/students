package com.guided.selector.portlet;

import com.guided.selector.constants.GuidedSelectorPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.search.query.Queries;
import com.liferay.portal.search.searcher.SearchRequestBuilderFactory;
import com.liferay.portal.search.searcher.Searcher;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author ag8
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=GuidedSelector",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + GuidedSelectorPortletKeys.GUIDEDSELECTOR,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class GuidedSelectorPortlet extends MVCPortlet {
	 @Reference
		protected Queries queries;
		
		@Reference
		protected Searcher searcher;
		
		@Reference
		protected SearchRequestBuilderFactory searchRequestBuilderFactory;
		

		
			public void autoSearch(ActionRequest actionRequest, ActionResponse actionResponse)
					throws IOException, PortletException {
		
			
//	  ThemeDisplay themeDisplay = (ThemeDisplay)
//			  actionRequest.getAttribute(WebKeys.THEME_DISPLAY); 
//	  
//	  String typeOfCar = ParamUtil.getString(actionRequest, "typeOfCar");
//	  String noOfSeats = ParamUtil.getString(actionRequest, "noOfSeats");
//	  String priceRange = ParamUtil.getString(actionRequest, "priceRange");
//	  
//	  String[]  keyworkds = {noOfSeats,priceRange};
//	  
//		  System.out.println("typeOfCar--- "+typeOfCar);
//		  System.out.println("noOfSeats--- "+noOfSeats);
//		  System.out.println("priceRange--- "+priceRange);
//
//	  TermsQuery termsQuery = queries.terms(Field.FOLDER_ID);
//	  MatchQuery matchQuery = queries.match(Field.getLocalizedName(LocaleUtil.US, Field.ASSET_TAG_NAMES), typeOfCar);
//	  BooleanQuery booleanQuery =  queries.booleanQuery();
//	  
//	  termsQuery.addValues(String.valueOf(
//				JournalFolderConstants.DEFAULT_PARENT_FOLDER_ID));
//	  
//	  booleanQuery.addMustQueryClauses(termsQuery, matchQuery);
//
//		SearchRequestBuilder searchRequestBuilder =
//				searchRequestBuilderFactory.builder();
//
//	  
//	  searchRequestBuilder.withSearchContext(
//			    searchContext -> {
//			        searchContext.setCompanyId(themeDisplay.getCompanyId());
//			        searchContext.setKeywords(typeOfCar);
//			        searchContext.setAssetTagNames(keyworkds);
//			        
//			    });
//	 
//	  
//	  SearchRequest searchRequest = 
//			   searchRequestBuilder.query( booleanQuery).build();
//	  
//	  //TermFilter termFilter = new TermFilter("fieldName", "filterValue");
//	  
//	  //SearchRequest searchRequestfilter = 
//		//	     searchRequestBuilder.postFilterQuery((Query) termFilter).build();
//	  
//	  SearchResponse searchResponse = searcher.search(searchRequest);
//	  
//	  SearchHits searchHits = searchResponse.getSearchHits();
//	  List<SearchHit> searchHitsList = searchHits.getSearchHits();
//	  searchHitsList.forEach(
//				searchHit -> {
//					float hitScore = searchHit.getScore();
//
//					Document doc = searchHit.getDocument();
//					
//					
//					
//					String uid = doc.getString(Field.UID);
//					
//					List<Object> tagid = doc.getValues(Field.ASSET_TAG_NAMES);
//
//					for(Object ob : tagid) {
//						if(ob.toString().equalsIgnoreCase(keyworkds[0])) {
//							System.out.println("********TAGS*******"+ob);
//						}else if(ob.toString().equalsIgnoreCase(keyworkds[1])) {
//							System.out.println("********TAGS*******"+ob);
//						}
//						
//					}
//					System.out.println("document---- ");
//				});
	 
	  
	  }
	  
//	  protected SearchContext buildSearchContext() {
//			SearchContext searchContext = _searchContextBuilder.getSearchContext();
//
//			searchContext.setAttribute("filterExpired", Boolean.TRUE);
//			searchContext.setAttribute("paginationType", "more");
//
//			return searchContext;
//		}
	  
	 // private final SearchRequestBuilderFactory _searchRequestBuilderFactory;
	 // private final SearchContextBuilder _searchContextBuilder;
	  
	  /*try { 
		  String[] tagesNames = {"hatchback"}; 
		  
		  List<JournalArticle> journalArticles = getArticleByTags(themeDisplay.getScopeGroupId(), tagesNames);
	  
	  for (JournalArticle journalArticle : journalArticles) {

	  System.out.println("_____________________journal----------------" + journalArticle.getTitle("en_US"));
	  
	  }
	 
	  
	  // renderRequest.setAttribute("journalArticles", journalArticles); 
	  } 
	  catch (SystemException e){
		  e.getMessage(); } 
	  catch (PortalException e) {
		  e.getMessage(); }
	  
	  //include("/view_search.jsp", renderRequest, renderResponse); 
	  }*/
	  
	  /*
	  public List<JournalArticle> getArticleByTags(long groupId, String[] tagName)
	  throws PortalException, SystemException {
		  
		  AssetEntryQuery assetEntryQuery =new AssetEntryQuery(); 
		  long[] anyTagIds = AssetTagLocalServiceUtil.getTagIds(groupId, tagName);
	  
		  assetEntryQuery.setAnyTagIds(anyTagIds); 
		  List<AssetEntry> assetEntryList = AssetEntryLocalServiceUtil.getEntries(assetEntryQuery);
	  
	  List<JournalArticle> journalArticleList = new ArrayList<JournalArticle>();
	  
	  for (AssetEntry ae : assetEntryList) {
		  JournalArticleResource journalArticleResourceObj = JournalArticleResourceLocalServiceUtil.getJournalArticleResource(ae.getClassPK()); 
		  JournalArticle journalArticleObj = JournalArticleLocalServiceUtil.getArticle(groupId,journalArticleResourceObj.getArticleId());
	  
		  journalArticleList.add(journalArticleObj); } 
	  return journalArticleList; 
	  }
	  */
	 
}