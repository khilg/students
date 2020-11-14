<!DOCTYPE html>

<#include init />

<html class="${root_css_class}" dir="<@liferay.language key="lang.dir" />" lang="${w3c_language_id}">

<head>
<link href="https://gitcdn.github.io/bootstrap-toggle/2.2.2/css/bootstrap-toggle.min.css" rel="stylesheet">
	<title>${the_title} - ${company_name}</title>

	<meta content="initial-scale=1.0, width=device-width" name="viewport" />

	<@liferay_util["include"] page=top_head_include />
</head>

<body class="${css_class}">

<@liferay_ui["quick-access"] contentId="#main-content" />

<@liferay_util["include"] page=body_top_include />

<@liferay.control_menu />


	<header class="${header_css_class} auto-bg" id="header-theme-toggler">
	<div class="container-fluid" id="banner" role="banner">
	<div class="auto-logo-container">
		<a class="${logo_css_class} logo auto-logo-anc" href="${site_default_url}" title="<@liferay.language_format arguments="${site_name}" key="go-to-x" />">
			<img alt="${logo_description}" class="auto-logo-img" height="${site_logo_height}" src="${site_logo}" />
			<#if show_site_name>
				<div class="auto-logo-name">
				<span>${site_name}</span>
				<h4><i>Caring for you always...</i></h4>
				</div>
			</#if>
		</a>
	</div>
	<span class="auto-theme-toggler">
		
		  
	</span>
		<#if has_navigation>
		 <button aria-controls="navigation" 
		    aria-expanded="false" 
		    class="btn-monospaced ml-auto navbar-toggler" 
		    data-target="#lunarNav" 
		    data-toggle="collapse" 
		    type="button">
		    <span class="navbar-toggler-icon"></span>
		  </button>
		  
			<#include "${full_templates_path}/navigation.ftl" />
		</#if>
	</div>
</header>
<div class="container-fluid mt-0 pt-0 px-0"  id="wrapper">
	<#if wrap_widget_page_content >
		<#assign portal_content_css_class = "container" />
	<#else>
		<#assign portal_content_css_class = "container-fluid" />
	</#if>
	<section class="${portal_content_css_class}" id="content">
		<h2 class="hide-accessible" role="heading" aria-level="1">${the_title}</h2>

		<#if selectable>
			<@liferay_util["include"] page=content_include />
		<#else>
			${portletDisplay.recycle()}

			${portletDisplay.setTitle(the_title)}

			<@liferay_theme["wrap-portlet"] page="portlet.ftl">
				<@liferay_util["include"] page=content_include />
			</@>
		</#if>
	</section>

	
		<#if show_footer>
	<#include "${full_templates_path}/footer.ftl" />
</#if>

</div>

<@liferay_util["include"] page=body_bottom_include />

<@liferay_util["include"] page=bottom_include />
<script src="${javascript_folder}/plugins/owl.carousel.min.js"></script>
<script src="${javascript_folder}/plugins/bootstrap-multiselect.js"></script>
<script src="${javascript_folder}/plugins/jquery.validate.js"></script>
<script src="https://unpkg.com/gijgo@1.9.13/js/gijgo.min.js"></script>
<script src="${javascript_folder}/plugins/jquery.dirrty.js"></script>

<script src="https://gitcdn.github.io/bootstrap-toggle/2.2.2/js/bootstrap-toggle.min.js"></script>
<script>

$( document ).ready(function() {
	
    $('.auto-theme-toggler').html('<label class="switch"><input type="checkbox" id="auto-dark-theme" value="darkTheme"><span class="slider round"></span></label>');
	
	var autoTheme = localStorage.getItem("autoTheme");
	
	$('.auto-theme-toggler').click(function(){
	
        if($("#auto-dark-theme").prop("checked") == false){
           localStorage.setItem("autoTheme", "light");
           $("#header-theme-toggler").removeClass("navbar-dark bg-dark");
		$("#header-theme-toggler").addClass("navbar-light bg-light");
		$("#footer").removeClass("bg-dark");
        }
        else if($("#auto-dark-theme").prop("checked") == true){
           localStorage.setItem("autoTheme", "dark");
           $("#header-theme-toggler").removeClass("navbar-light bg-light");
		$("#header-theme-toggler").addClass("navbar-dark bg-dark");
		$("#footer").addClass("bg-dark");
        }

	});

	if(autoTheme == "light"){
		$("#auto-dark-theme").prop("checked",false);
		$("#header-theme-toggler").removeClass("navbar-dark bg-dark");
		$("#header-theme-toggler").addClass("navbar-light bg-light");
		$("#footer").removeClass("bg-dark");
		
	}else if(autoTheme == 'dark'){
	    $("#auto-dark-theme").prop("checked",true);
		$("#header-theme-toggler").removeClass("navbar-light bg-light");
		$("#header-theme-toggler").addClass("navbar-dark bg-dark");
		$("#footer").addClass("bg-dark");
	}
	    
	});



</script>
</body>

</html>