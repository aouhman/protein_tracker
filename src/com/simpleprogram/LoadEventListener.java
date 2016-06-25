package com.simpleprogram;

import org.hibernate.HibernateException;
import org.hibernate.event.internal.DefaultLoadEventListener;
import org.hibernate.event.spi.LoadEvent;

/**
 * Created by admin on 24/06/2016.
 */
public class LoadEventListener  extends DefaultLoadEventListener {
    @Override
    public void onLoad(LoadEvent event, LoadType loadType) throws HibernateException {
        System.out.print("Entity loaded");
        System.out.print(event.getEntityId());

    }
}
