<footer id="footer" role="contentinfo" class="auto-light-footer">
  <div id="navbarContactWrapper" class="row mx-0">
  <nav id="navbarFooter" class="col-12 col-md-6 pt-5">
  <div id="socialMediaWrapper" class="col-12 col-md-4 text-center mx-auto mb-4">
    <h2 class="nav-heading">
        Follow Us
    </h2>
    <div id="socialMediaLinks">
      <ul class="nav flex-row mx-auto">
          <li class="mx-2">
              <div id="facebook"><a class="text-white"
              href="http://www.facebook.com" 
              target="_blank"><span class="hide">Facebook</span>
              <@clay["icon"] symbol="social-facebook" />
              </a></div>
          </li>
          <li class="mx-2">
              <div id="twitter"><a class="text-white" 
              href="http://www.twitter.com" 
              target="_blank"><span class="hide">Twitter</span>
              <@clay["icon"] symbol="twitter" />
              </a></div>
          </li>
          <li class="mx-2">
              <div id="linked-in"><a class="text-white"
              href="http://www.linkedin.com" 
              target="_blank"><span class="hide">LinkedIn</span>
              <@clay["icon"] symbol="social-linkedin" />
              </a></div>
          </li>
          <li class="mx-2">
              <div id="youtube"><a class="text-white"
              href="http://www.youtube.com" 
              target="_blank"><span class="hide">YouTube</span>
              <@clay["icon"] symbol="video" />
              </a></div>
          </li>
      </ul>
    </div>
  </div>
    <div class="text-center mx-auto">
      <div class="nav text-uppercase" role="menubar">
        <#assign preferencesMap = {"displayDepth": "1", "portletSetupPortletDecoratorId": "barebone"} />

        <@liferay.navigation_menu
          default_preferences=freeMarkerPortletPreferences.getPreferences(preferencesMap)
          instance_id="footer_navigation_menu"
        />
      </div>
    </div>
  </nav>
    <div class="contact-info-container text-center pt-5 pb-2 col-12 col-md-4 mx-auto mb-4">
      <img alt="auto-pilot-logo" height="100" class="mb-2" src="${site_logo}" />
      <div id="contactTextWrapper" class="row mx-0">
      <div class="col-md-6">
        <p>
          #123 XYZ Colony<br>
          Bengaluru, Karnataka 560010
        </p>
        </div>
         <div class="col-md-6">
        <p>
          Tel: 4-919-843-6666<br>
          Tel: 4-919-843-6666<br>
          <a href="#">auto-pilot@gmail.com</a>
        </p>
        </div>
      </div>
    </div>
  </div>
</footer>