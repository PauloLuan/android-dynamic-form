package terracore.example.forms;

import terracore.formgenerator.FormActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class FormGeneratorExample extends FormActivity {
        
        @Override
        public void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                generateForm(FormActivity.parseFileToString(this, "bauru.json"));
        }
        
        @Override
        public void saveTask(String resultJson) {
                Log.e("JSON Recebido para salvar! ", resultJson);
        }
        
        @Override
        public void deleteTask() {}
        
        /**
         * ===============================================================
         * 
         * Only tests functions (deprecated)
         * 
         * ===============================================================
         * */
        public void finishResultOk() {
                String result = save().toString(); // TODO: QUAL É O ATRIBUTO DE IDENTIFICAÇÃO?
                Intent data = new Intent();
                
                data.putExtra("type", "save");
                data.putExtra("data", result);
                
                setResult(RESULT_OK, data);
                finish();
        }
        
        public void finishResultDelete() {
                String result = save().toString(); // TODO: QUAL É O ATRIBUTO DE IDENTIFICAÇÃO?
                Intent data = new Intent();
                
                data.putExtra("type", "delete");
                data.putExtra("data", result);
                
                setResult(RESULT_OK, data);
                finish();
        }
        
        public void finishResultCancel() {
                setResult(RESULT_CANCELED, new Intent());
                finish();
        }
        
        protected void onActivityResultExample(
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