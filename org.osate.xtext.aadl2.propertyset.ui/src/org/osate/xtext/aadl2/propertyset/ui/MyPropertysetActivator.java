package org.osate.xtext.aadl2.propertyset.ui;

import org.apache.log4j.Logger;
import org.osate.core.OsateCorePlugin;
import org.osate.xtext.aadl2.propertyset.ui.internal.PropertysetActivator;
import org.osgi.framework.BundleContext;

import static com.google.inject.util.Modules.override;
import static com.google.inject.Guice.createInjector;

import com.google.inject.Injector;

public class MyPropertysetActivator extends PropertysetActivator {

	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		try {
			registerInjectorFor(ORG_OSATE_XTEXT_AADL2_PROPERTYSET_PROPERTYSET);
			
		} catch (Exception e) {
			Logger.getLogger(getClass()).error(e.getMessage(), e);
			throw e;
		}
	}
	@Override
	public Injector getInjector(String languageName) {
		return OsateCorePlugin.getDefault().getInjector(languageName);
	}
	
	protected void registerInjectorFor(String language) throws Exception {
		OsateCorePlugin.getDefault().registerInjectorFor(language, 
				createInjector(
		  override(override(getRuntimeModule(language)).with(getSharedStateModule())).with(getUiModule(language))));
	}

}