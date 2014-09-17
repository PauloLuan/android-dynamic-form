package terracore.formgenerator.camera;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import makemachine.android.examples.forms.R;
import terracore.formgenerator.FormWidget;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;

public class FormCamera extends FormWidget implements Serializable {
        private Button            cameraButton;
        private LinearLayout      photosPreview;
        protected int             _priority;
        
        private static FormCamera instance;
        private Context           context;
        
        List<String>              photos = new ArrayList<String>();
        
        public FormCamera(Context context, String propertyName) {
                super(context, "");
                
                this.context = context;
                instance = this;
                
                cameraButton = new Button(context);
                cameraButton.setText(propertyName);
                
                Drawable icon = context.getResources().getDrawable(R.drawable.ic_action_camera);
                cameraButton.setCompoundDrawablesWithIntrinsicBounds(null, null, null, icon);
                
                setOnCameraButtonClickListener();
                
                _layout.addView(cameraButton);
        }
        
        public void setOnCameraButtonClickListener() {
                cameraButton.setOnClickListener(new OnClickListener() {
                        @Override
                        public void onClick(View v) {
                                Intent intent = new Intent(context, CameraActivity.class);
                                context.startActivity(intent);
                        }
                });
        }
        
        public List<String> getPhotos() {
                return photos;
        }
        
        public void setPhotos(List<String> photos) {
                this.photos = photos;
        }
        
        /**
         * Callback that will be called when the picture was taken, add the
         * photo to array and updates the UI of the preview photos
         * 
         * @param path
         */
        public void addPhoto(String photo) {
                photos.add(photo);
                updatePhotos();
        }
        
        public void updatePhotos() {
                // TODO: update the photos layout
        }
        
        public static FormCamera getInstance() {
                return instance;
        }
        
}
