package xi.org.xispeech;

import android.os.Bundle;
import android.speech.RecognitionListener;
import android.speech.SpeechRecognizer;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anakin on 26/9/14.
 */
public class XiRecognitionLister implements RecognitionListener {


    static final String TAG = XiRecognitionLister.class.getCanonicalName();



    @Override
    public void onReadyForSpeech(Bundle bundle) {

    }

    public void onBeginningOfSpeech(){

        Log.i( TAG , "Beginning of speech detected");
    }

    public void onEndOfSpeech(){
        Log.i(TAG, "End of Speech detected");
    }

    @Override
    public void onError(int i) {
        Log.i(TAG , diagnoseErrorCode(i));
    }


    public void onResults( Bundle results){

        Log.i(TAG, "Results: " );

        for(String s: getResults(results)){

            Log.i(TAG, s);

        }

    }



    public List<String> getResults( Bundle bundle){
        List<String> results = new ArrayList<String>();
        if ((results != null)
                && bundle.containsKey(SpeechRecognizer.RESULTS_RECOGNITION))
        {
            results =
                    bundle.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);
        }
        return results;
    }
    @Override
    public void onPartialResults(Bundle bundle) {

        Log.i(TAG, "Partial results:" + bundle.toString());


    }

    @Override
    public void onEvent(int i, Bundle bundle) {

    }

    public void onRmsChanged(float f){

    }

    @Override
    public void onBufferReceived(byte[] bytes) {

    }

    public static String diagnoseErrorCode(int errorCode)
    {
        String message;
        switch (errorCode)
        {
            case SpeechRecognizer.ERROR_AUDIO:
                message = "Audio recording error";
                break;
            case SpeechRecognizer.ERROR_CLIENT:
                message = "Client side error";
                break;
            case SpeechRecognizer.ERROR_INSUFFICIENT_PERMISSIONS:
                message = "Insufficient permissions";
                break;
            case SpeechRecognizer.ERROR_NETWORK:
                message = "Network error";
                break;
            case SpeechRecognizer.ERROR_NETWORK_TIMEOUT:
                message = "Network timeout";
                break;
            case SpeechRecognizer.ERROR_NO_MATCH:
                message = "No match";
                break;
            case SpeechRecognizer.ERROR_RECOGNIZER_BUSY:
                message = "RecognitionService busy";
                break;
            case SpeechRecognizer.ERROR_SERVER:
                message = "error from server";
                break;
            case SpeechRecognizer.ERROR_SPEECH_TIMEOUT:
                message = "No speech input";
                break;
            default:
                message = "Didn't understand, please try again.";
                break;
        }
        return message;
    }
}
