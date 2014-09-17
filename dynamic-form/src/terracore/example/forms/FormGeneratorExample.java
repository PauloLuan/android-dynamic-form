package terracore.example.forms;

import terracore.formgenerator.FormActivity;
import android.os.Bundle;

public class FormGeneratorExample extends FormActivity {
        
        @Override
        public void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                generateForm(FormActivity.parseFileToString(this, "camera.json"));
                save();
        }
}