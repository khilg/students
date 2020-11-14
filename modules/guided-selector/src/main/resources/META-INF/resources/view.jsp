<%@include file="./init.jsp"%>
<%@page import="com.liferay.journal.model.JournalArticleDisplay"%>
<%@page import="com.liferay.journal.model.JournalArticle"%>
<%@page import="com.liferay.journal.service.JournalArticleLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.Tuple"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="java.util.Arrays"%>



<portlet:actionURL name="autoSearch" var="searchURL" />

<portlet:renderURL var="viewURL">
    <portlet:param 
        name="mvcPath" 
        value="/view.jsp" 
    />
</portlet:renderURL>
<aui:form action="${searchURL}" name="fm">

    <div class="container">
    <div class="row">
        <div class="col-md-8">
           <aui:select name="typeOfCar" id="typeOfCar" label ="Type of Car">
	            <aui:option  value="suv">SUV</aui:option>
	            <aui:option  value="hatchback">HATCHBACK</aui:option>
	            <aui:option  value="sedan">SEDAN</aui:option>
		   </aui:select> 
        </div>
  </div>
  <div class="row">
        <div class="col-md-8">
           <aui:select name="priceRange" id="priceRange" label ="Price Range">
	            <aui:option  value="10lakhormore">10 Lakhs or More</aui:option>
	            <aui:option  value="5-10lakhs">5-10 Lakhs</aui:option>
		   </aui:select> 
        </div>
  </div>
  <div class="row">
        <div class="col-md-8">
           <aui:select name="noOfSeats" id="noOfSeats" label ="No of Seats">
	            <aui:option  value="4-seater">4 Seater</aui:option>
	            <aui:option  value="6-seater">6 Seater</aui:option>
		   </aui:select> 
        </div>
  </div>
 
        <div class="col-md-4">
            <aui:button type="submit" value="Submit" />
        </div>
   </div>
</aui:form>

	<%
	
	String typeOfCar = ParamUtil.getString(request, "typeOfCar");
	String noOfSeats = ParamUtil.getString(request, "noOfSeats");
	String priceRange = ParamUtil.getString(request, "priceRange");
	
	%>
<liferay-portlet:renderURL varImpl="iteratorURL">
	<portlet:param name="mvcPath" value="/view_search.jsp" />
	<portlet:param name="typeOfCar" value="<%= typeOfCar %>" />
</liferay-portlet:renderURL>

<liferay-ui:search-container
	emptyResultsMessage='<%= LanguageUtil.format(request, "No results found for the combination", "<strong>" + typeOfCar + "</strong>", false) %>'
	iteratorURL="<%= iteratorURL %>"
>

	<%
     	String[] assetTagArr = {noOfSeats,priceRange};
	
		 SearchContext searchContext = SearchContextFactory.getInstance(request);
		 searchContext.setAttribute("paginationType", "regular");
	
		 searchContext.setKeywords(typeOfCar);
		 searchContext.setAssetTagNames(assetTagArr);
	
	    Indexer<JournalArticle> indexer = IndexerRegistryUtil.getIndexer(JournalArticle.class);
		Hits hits = indexer.search(searchContext);
		ArrayList<Tuple> tuples = new ArrayList<Tuple>();
	
	for (int i = 0; i < hits.getDocs().length; i++) {
		Object[] array = new Object[5];
		Document document = hits.doc(i);
		array[0] = document.get(Field.ENTRY_CLASS_PK);
		String iid = document.get(Field.ENTRY_CLASS_PK);
		JournalArticle journalArticle = JournalArticleLocalServiceUtil.fetchLatestArticle(Long.parseLong(iid));
		String  articleId = journalArticle.getArticleId();
		JournalArticleDisplay articleDisplay = JournalArticleLocalServiceUtil.getArticleDisplay(themeDisplay.getLayout().getGroupId(), articleId, "", "", themeDisplay);
		
		
		array[1] = articleDisplay.getContent();
				//JournalArticleLocalServiceUtil.fetchLatestArticle(Long.parseLong(iid)).getContent();
		//System.out.println(JournalArticleLocalServiceUtil.fetchLatestArticle(Long.parseLong(iid)).getContent());
		array[2] = document.get(Field.ASSET_TAG_NAMES);
		 
		String [] assettages = GetterUtil.getStringValues(document.getValues(Field.ASSET_TAG_NAMES));
		
		 ArrayList<String> requidTagList = new ArrayList<String>();
		 
		 for(String at : assettages){
			 requidTagList.add(at);
	       }
		
		long userId = GetterUtil.getLong(document.get(Field.USER_ID));
		String userName = document.get(Field.USER_NAME);
		array[3] = PortalUtil.getUserName(userId, userName);

		 if(requidTagList.contains(typeOfCar) && requidTagList.contains(noOfSeats) && requidTagList.contains(priceRange) ){
			 tuples.add(new Tuple(array));
		 }
		
	}
	
	searchContainer.setResults(tuples);
	searchContainer.setTotal(hits.getLength());
	%>

	<liferay-ui:search-container-row
		className="com.liferay.portal.kernel.util.Tuple"
		modelVar="tuple"
	>
			
		<liferay-ui:search-container-column-text
			name="title"
			orderable="<%= true %>"
			value="<%= (String)tuple.getObject(1) %>"
		/>

	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>
