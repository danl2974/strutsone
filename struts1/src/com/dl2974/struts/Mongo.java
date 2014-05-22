package com.dl2974.struts;

import java.net.UnknownHostException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

public class Mongo {
	
	private MongoClient client;
	private DBCollection collection;
	private DB db;
	private Log log = LogFactory.getLog("Mongo");
	
	public Mongo(){
		
		try {
			this.client = new MongoClient( "localhost" , 27017 );
			this.db = client.getDB("maindb");
        	boolean auth = db.authenticate("dbuser", "nibul7474".toCharArray());
		} catch (UnknownHostException e) {
			log.error(e.getMessage());
		}
	}
	
	
	public void setCollection(String collectionName){
		
		this.collection = db.getCollection(collectionName);
		
	}
	
	public long getCount(){
		return this.collection.count();
	}
	
	
	
	

}
