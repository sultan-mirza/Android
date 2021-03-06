package kk.play.stockmanagement.utils;

import kk.play.stockmanagement.database.CyclesItemDBHandler;
import kk.play.stockmanagement.database.MysqlSynchronizer;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class StockManagementService extends Service{

	@Override
	public void onCreate() {
		}

	@Override
	public void onDestroy() {

	}

	@Override
	public void onStart(Intent intent, int startId) {
		
		if(isDBNotSynced()){
			Toast.makeText(getApplicationContext(), "Syncing databases...",
			        Toast.LENGTH_LONG).show();
		MysqlSynchronizer sync=new MysqlSynchronizer(getApplication());
		sync.synchronize();
		}else
		Toast.makeText(getApplicationContext(), "Databases already synced..!!!",
		        Toast.LENGTH_SHORT).show();
	}

	@Override
	public IBinder onBind(Intent intent) {

		return null;
	}
boolean isDBNotSynced(){
		CyclesItemDBHandler handler=new CyclesItemDBHandler(getApplicationContext());
		return handler.getAllFalseFlagCycles().size()>0;
	}
	
}
