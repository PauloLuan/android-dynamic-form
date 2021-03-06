package terracore.formgenerator.accordion;

import java.util.List;

import makemachine.android.examples.forms.R;
import terracore.formgenerator.FormWidget;
import android.content.Context;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

public class FormAccordion extends FormWidget {
        private List<String> childrenIds;
        private LinearLayout childrenLayout;
        private String       name;
        
        public FormAccordion(
                             Context context,
                             String name,
                             List<String> childrenIds) {
                super(context, name);
                
                this.name = name;
                
                this.childrenIds = childrenIds;
                
                _label.setText(name);
                _label.setCompoundDrawablesWithIntrinsicBounds(R.drawable.up, 0, 0, 0);
                
                childrenLayout = new LinearLayout(context);
                childrenLayout.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
                childrenLayout.setOrientation(LinearLayout.VERTICAL);
                
                LayoutParams titleLayoutParams = new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT);
                titleLayoutParams.topMargin = 60;
                titleLayoutParams.bottomMargin = 60;
                
                _label.setLayoutParams(titleLayoutParams);
                _label.setGravity(Gravity.CENTER_HORIZONTAL);
                _label.setTextSize(25);
                
                _layout.addView(childrenLayout);
                
                setLabelOnClick();
        }
        
        public void setLabelOnClick() {
                _label.setOnClickListener(new OnClickListener() {
                        @Override
                        public void onClick(View arg0) {
                                collapse();
                        }
                });
        }
        
        public void collapse() {
                if (childrenLayout.getVisibility() == View.VISIBLE) {
                        _label.setCompoundDrawablesWithIntrinsicBounds(R.drawable.up, 0, 0, 0);
                        childrenLayout.setVisibility(View.GONE);
                        Log.e("", "gone");
                }
                else {
                        _label.setCompoundDrawablesWithIntrinsicBounds(R.drawable.down, 0, 0, 0);
                        childrenLayout.setVisibility(View.VISIBLE);
                        Log.e("", "Visible");
                        
                }
        }
        
        public List<String> getChildrenIds() {
                return childrenIds;
        }
        
        public void setChildrenIds(List<String> childrenIds) {
                this.childrenIds = childrenIds;
        }
        
        public void addChildWidget(LinearLayout layout) {
                childrenLayout.addView(layout);
        }
}