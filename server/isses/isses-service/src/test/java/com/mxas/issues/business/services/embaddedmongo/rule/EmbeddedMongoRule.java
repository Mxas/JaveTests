package com.mxas.issues.bussines.services.embaddedmongo.rule;

import org.junit.rules.ExternalResource;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.MongoClient;

import de.flapdoodle.embed.mongo.MongodExecutable;
import de.flapdoodle.embed.mongo.MongodStarter;
import de.flapdoodle.embed.mongo.config.IMongodConfig;
import de.flapdoodle.embed.mongo.config.MongodConfigBuilder;
import de.flapdoodle.embed.mongo.config.Net;
import de.flapdoodle.embed.mongo.distribution.Version;
import de.flapdoodle.embed.process.runtime.Network;

public class EmbeddedMongoRule extends ExternalResource {
    public static final String HOST = "localhost";
    public static final int PORT = 12345;
    public static final String DBNAME = "mongo-test";

    private MongodExecutable mongodExecutable;
    private MongoTemplate mongoTemplate;

    @Override
    protected void before() throws Throwable {
        super.before();


        IMongodConfig mongodConfig =
                new MongodConfigBuilder().version(Version.Main.PRODUCTION).net(new Net(PORT, Network.localhostIsIPv6())).build();

        MongodStarter starter = MongodStarter.getDefaultInstance();
        mongodExecutable = starter.prepare(mongodConfig);
        mongodExecutable.start();
        mongoTemplate = new MongoTemplate(new MongoClient(HOST, PORT), DBNAME);
    }

    @Override
    public void after() {
        if (mongoTemplate != null) {
            mongoTemplate.getDb().drop();
        }
        if (mongodExecutable != null) {
            mongodExecutable.stop();
        }
    }


}
