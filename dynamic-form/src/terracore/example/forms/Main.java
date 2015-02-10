package terracore.example.forms;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class Main extends Activity {
        
        @Override
        public void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                Intent intent = new Intent(this, FormGeneratorExample.class);
                startActivityForResult(intent, 123);
        }
        
        @Override
        protected void onActivityResult(
                                        int requestCode,
                                        int resultCode,
                                        Intent data) {
                String result = (String) data.getExtras().getSerializable("data");
                String type = (String) data.getExtras().getSerializable("type");
                
                if (type.equals("save")) {
                        // new Form().setPreenchimentoDoForm(result)
                        // dao.save() e o ID do form? vai criar um novo?
                }
                else if (type.equals("delete")) {
                        // dao.remove(result); // e o ID ?
                }
                
                super.onActivityResult(requestCode, resultCode, data);
        }
}