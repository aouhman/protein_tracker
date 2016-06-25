package com.simpleprogram;

import org.hibernate.cfg.Configuration;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.event.service.spi.EventListenerRegistry;
import org.hibernate.event.spi.EventType;
import org.hibernate.integrator.spi.Integrator;
import org.hibernate.metamodel.source.MetadataImplementor;
import org.hibernate.service.spi.SessionFactoryServiceRegistry;

/**
 * Created by admin on 24/06/2016.
 */
public class DefaultIntegrator  implements Integrator{

    @Override
    public void integrate(Configuration configuration, SessionFactoryImplementor sessionFactoryImplementor, SessionFactoryServiceRegistry sessionFactoryServiceRegistry) {
        EventListenerRegistry r = sessionFactoryServiceRegistry.getService(EventListenerRegistry.class);
        r.prependListeners(EventType.LOAD, new LoadEventListener());
    }

    @Override
    public void integrate(MetadataImplementor metadataImplementor, SessionFactoryImplementor sessionFactoryImplementor, SessionFactoryServiceRegistry sessionFactoryServiceRegistry) {

    }

    @Override
    public void disintegrate(SessionFactoryImplementor sessionFactoryImplementor, SessionFactoryServiceRegistry sessionFactoryServiceRegistry) {

    }
}
