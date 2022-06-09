package edu.hebut.mycontextmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    
    final static int CONTEXT_MENU_1 = Menu.FIRST;
    final static int CONTEXT_MENU_2 = Menu.FIRST+1;
    final static int CONTEXT_MENU_3 = Menu.FIRST+2;
    TextView LabelView = null;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LabelView = (TextView)findViewById(R.id.label);
        registerForContextMenu(LabelView);
    }
    
    @Override
    public void onCreateContextMenu(ContextMenu menu,
                                    View v, ContextMenu.ContextMenuInfo menuInfo){
        menu.setHeaderTitle("Center Menu");
        menu.add(0, CONTEXT_MENU_1, 0,"Item 1");
        menu.add(0, CONTEXT_MENU_2, 1,"Item 2");
        menu.add(0, CONTEXT_MENU_3, 2,"Item 3");
    }
    
    @Override
    public boolean onContextItemSelected(MenuItem item){
        switch(item.getItemId()){
            case CONTEXT_MENU_1:
                LabelView.setText("Item 1");
                return true;
            case CONTEXT_MENU_2:
                LabelView.setText("Item 2");
                return true;
            case CONTEXT_MENU_3:
                LabelView.setText("Item 3");
                return true;
        }
        return false;
    }
}