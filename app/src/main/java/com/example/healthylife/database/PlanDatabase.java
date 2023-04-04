//package com.example.healthylife.database;
//
//import android.content.Context;
//
//import androidx.room.Database;
//import androidx.room.Room;
//import androidx.room.RoomDatabase;
//
//import com.example.healthylife.Model.Plan;
//
//@Database(entities = {Plan.class}, version = 1)
//public abstract class PlanDatabase extends RoomDatabase {
//    private static final String DATABASE_NAME = "plan.db";
//    private static PlanDatabase instance;
//
//    public static synchronized PlanDatabase getInstance(Context context) {
//        if (instance == null) {
//            instance = Room.databaseBuilder(context.getApplicationContext(),
//                    PlanDatabase.class, DATABASE_NAME)
//                    .allowMainThreadQueries()
//                    .build();
//        }
//        return instance;
//    }
//
//    public abstract DAO getDAO();
//}
