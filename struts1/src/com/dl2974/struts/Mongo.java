package com.dl2974.struts;

import java.net.UnknownHostException;
import java.util.Iterator;
import java.util.LinkedList;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
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
	
	
	public void queryCollection(String collectionName){
		
		this.collection = db.getCollection(collectionName);
		
	}
	
	public LinkedList<String> fetchAll(){
		
		LinkedList<String> ll = new LinkedList<String>();
		int counter = 0;
		DBCursor cursor = this.collection.find();
		Iterator<DBObject> iter = cursor.iterator();
		while(iter.hasNext()){
			counter++;
			BasicDBObject bdbo = (BasicDBObject) iter.next();
			for(String key: bdbo.keySet()){
			  if (bdbo.get(key) instanceof String){
				 ll.add(String.format("%d) %s  [%d]", counter, bdbo.get(key), bdbo.hashCode() ) );
			  }
			  else{
				 try{
		            ll.add(String.format("%d) %s", counter, String.valueOf(bdbo.get(key)) ) );
				  }catch(Exception e){ log.info(e.getMessage()); }
			  }
			}
		}
		
		return ll;
		
	}
	
	public long getCount(){
		return this.collection.count();
	}
	
	
	
	

}
