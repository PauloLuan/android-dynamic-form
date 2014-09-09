package makemachine.android.examples.forms;

import makemachine.android.formgenerator.FormActivity;
import android.os.Bundle;

public class FormGeneratorExample extends FormActivity {
        
        @Override
        public void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                generateForm(FormActivity.parseFileToString(this, "bauru.json"));
                save();
        }
}