package org.waastad.tomeejaxrsvalidation.domain.finder;

import com.avaje.ebean.Finder;
import org.waastad.tomeejaxrsvalidation.domain.User;
import org.waastad.tomeejaxrsvalidation.domain.query.QUser;

public class UserFinder extends Finder<Long, User> {

    /**
     * Construct using the default EbeanServer.
     */
    public UserFinder() {
        super(User.class);
    }

    /**
     * Construct with a given EbeanServer.
     */
    public UserFinder(String serverName) {
        super(User.class, serverName);
    }

    /**
     * Start a new typed query.
     */
    public QUser where() {
        return new QUser(db());
    }

    /**
     * Start a new document store query.
     */
    public QUser text() {
        return new QUser(db()).text();
    }

    public User byName(String name) {
        return where().name.eq(name).findUnique();
    }

    public User findByRaw() {
        return where().name.eq("xxx")
                .raw("pets.value = id").findUnique();
    }
}
