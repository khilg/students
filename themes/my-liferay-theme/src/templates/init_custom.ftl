<#assign site_logo_height = 56 />

<#assign header_css_class = 
"navbar navbar-expand-md navbar-light bg-light " 
/>

<#assign logo_css_class = logo_css_class + " navbar-brand" />

<#assign
  show_footer = getterUtil.getBoolean(themeDisplay.getThemeSetting("show-footer"))
  wrap_widget_page_content = getterUtil.getBoolean(themeDisplay.getThemeSetting("wrap-widget-page-content"))
/>

