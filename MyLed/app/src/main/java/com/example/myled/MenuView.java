package com.example.myled;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.UUID;

import androidx.appcompat.app.AppCompatActivity;

public class MenuView extends AppCompatActivity {
    private Button next;
    public static final String DEVICE_EXTRA = "com.example.lightcontrol.SOCKET";
    public static final String DEVICE_UUID = "com.example.lightcontrol.uuid";
    private static final String DEVICE_LIST = "com.example.lightcontrol.devicelist";
    private static final String DEVICE_LIST_SELECTED = "com.example.lightcontrol.devicelistselected";
    public static final String BUFFER_SIZE = "com.example.lightcontrol.buffersize";
    private BluetoothAdapter mBTAdapter;
    private static final int BT_ENABLE_REQUEST = 10; // This is the code we use for BT Enable
    private static final int SETTINGS = 20;
   // private UUID mDeviceUUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");
    private int mBufferSize = 50000; //Default
    private static final String TAG = "BlueTest5-Controlling";
    private int mMaxChars = 50000;//Default//change this to string..........
    private UUID mDeviceUUID;
    private BluetoothSocket mBTSocket;
     //Controlling.ReadInput mReadThread = null;

    private boolean mIsUserInitiatedDisconnect = false;
    private boolean mIsBluetoothConnected = false;


    private Button mBtnDisconnect;
    private BluetoothDevice mDevice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_view);

        next = (Button) findViewById(R.id.search);


        Intent intent = getIntent();
        Bundle b = intent.getExtras();
        assert b != null;
        mDevice = b.getParcelable(MainActivity.DEVICE_EXTRA);
        mDeviceUUID = UUID.fromString(b.getString(MainActivity.DEVICE_UUID));
        mMaxChars = b.getInt(MainActivity.BUFFER_SIZE);


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // BluetoothDevice device =( (listView.getAdapter())).getSelectedItem();
                Intent next = new Intent(MenuView.this, Controlling.class);
                startActivity(next);
            //    next.putExtra(DEVICE_EXTRA, device);
                next.putExtra(DEVICE_UUID, mDeviceUUID.toString());
                next.putExtra(BUFFER_SIZE, mBufferSize);
                startActivity(next);
            }
        });


    }
}