package poly.com.config;

import java.util.Locale;

import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

public class TilesView extends UrlBasedViewResolver {
    @Override
    protected boolean isUrlRequired() {
        return false;
    }

    @Override
    protected View createView(String viewName, Locale locale) throws Exception {
        return new TilesJstlView(viewName);
    }
}
