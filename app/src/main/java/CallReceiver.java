package ao.co.isptec.aplm.callrecorderapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import android.util.Log;

public class CallReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // Verifica o estado do telefone
        String state = intent.getStringExtra(TelephonyManager.EXTRA_STATE);
        String incomingNumber = intent.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER);

        // Verifica o estado e o número da chamada
        if (state != null) {
            if (TelephonyManager.EXTRA_STATE_RINGING.equals(state)) {
                // O telefone está tocando (chamada recebida)
                Log.d("CallReceiver", "Chamada recebida de: " + incomingNumber);
            } else if (TelephonyManager.EXTRA_STATE_OFFHOOK.equals(state)) {
                // A chamada foi atendida (ou uma chamada efetuada)
                Log.d("CallReceiver", "Chamada ativa.");
            } else if (TelephonyManager.EXTRA_STATE_IDLE.equals(state)) {
                // A chamada foi encerrada
                Log.d("CallReceiver", "Chamada encerrada.");
            }
        }
    }
}


