package com.example.gridview;

// Girish Here

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.origamilabs.library.views.StaggeredGridView;





import android.support.v7.app.ActionBarActivity;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ClipData;
import android.content.ClipDescription;
import android.database.DataSetObserver;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnDragListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		final StaggeredGridView grid=(StaggeredGridView)findViewById(R.id.staggeredGridView1);
		
		grid.setAdapter(new adapter());
		
		
		
		
		/*grid.setOnTouchListener(new View.OnTouchListener() {

	        @Override
	        public boolean onTouch(View v, MotionEvent event) {

	            if (event.getAction() == MotionEvent.ACTION_DOWN) {
	            	StaggeredGridView parent = (StaggeredGridView) v;

	                int x = (int) event.getX();
	                int y = (int) event.getY();

	                int position = parent.pointToPosition(x, y);
	                if (position > AdapterView.INVALID_POSITION) {

	                    int count = parent.getChildCount();
	                    for (int i = 0; i < count; i++) {
	                        View curr = parent.getChildAt(i);
	                        
	                    }

	                    int relativePosition = position - parent.getFirstPosition();


	                    View target = (View) parent.getChildAt(relativePosition);

	                    DragGridItemHolder holder = (DragGridItemHolder) target.getTag();
	                    GridItem currentItem = holder.item;
	                    String text = currentItem.getFile().getAbsolutePath();

	                    ClipData data = ClipData.newPlainText("DragData", text);
	                    target.startDrag(data, new View.DragShadowBuilder(target), target, 0);
	                }
	            }
	            return false;
	        }});*/
		
			
	/*	grid.setOnDragListener(new OnDragListener() {
			
			@Override
			public boolean onDrag(View v, DragEvent event) {
				// TODO Auto-generated method stub
				
				//v.setLayoutParams(new LayoutParams(100, 100));
				v.setTranslationX(123);
				return true;
			}
		});*/
	}

	class adapter extends BaseAdapter
	{

		
		int source,dest,imvp;
		
		ArrayList<Integer> al=new ArrayList<>();
		ArrayList<Integer> al1=new ArrayList<>();
		
		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return 250;
		}

		@Override
		public Object getItem(int arg0) {
			// TODO Auto-generated method stub
			return arg0;
		}

		@Override
		public long getItemId(int arg0) {
			// TODO Auto-generated method stub
			return arg0;
		}
		private int getStringResourceByName(String aString) {
		      String packageName = getPackageName();
		      int resId = getResources().getIdentifier(aString, "color", packageName);
		      return resId;
		    }
		@SuppressLint("NewApi")
		@Override
		public View getView(int position, View arg1, ViewGroup arg2) {
			// TODO Auto-generated method stub
			LayoutInflater mInflater = (LayoutInflater) getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
			View view = mInflater.inflate(R.layout.image, null);
			final ImageView iv=(ImageView)view.findViewById(R.id.imageView1);
			
			
			
			TextView tv=(TextView)view.findViewById(R.id.textView1);
			
			Random rm=new Random();
			int i=1,j=0;
			if(al.size()<=position)
			{
			 i=(rm.nextInt(120)+30);
			 i=70;
			 j=rm.nextInt(19);
			 al.add(i);
			 al1.add(j);
			}else
			{
				i=al.get(position);
				j=al1.get(position);
			}
			int ii=getStringResourceByName("a"+(j+1));
			
			iv.setBackgroundColor(getResources().getColor(ii));
			tv.setTag(i);  
			Log.i("sacsaca", i+"");
			tv.setText(position+1+" "+i);
			iv.setLayoutParams(new android.widget.RelativeLayout.LayoutParams(400, i));
		
			iv.setTag(position);  
			
			iv.setOnLongClickListener(new OnLongClickListener() {
				
				@Override
				public boolean onLongClick(View view) {
					// TODO Auto-generated method stub
					/*Log.i("cxsdaszdas", (int)iv.getTag()+"qw");
				     float currentXPosition = motionEvent.getX();
				     float currentYPosition = motionEvent.getY();*/
				     //int position = grid.pointToPosition((int) currentXPosition, (int) currentYPosition);
				     View v =view;// grid.getChildAt(position);
				     ClipData.Item item = new ClipData.Item("" + (int)iv.getTag()); // here you send any data you want, I sent position
				     String[] mimeTypes = {ClipDescription.MIMETYPE_TEXT_HTML};
				     ClipData data = new ClipData("" + (int)iv.getTag(), mimeTypes, item);
				     View.DragShadowBuilder shadow = new View.DragShadowBuilder(v);
				     view.startDrag(data, shadow, null, 0);
				     
				     source=(int)iv.getTag();
				     //imvp=iv;
					return true;
				}
			});/*TouchListener(new OnTouchListener() {
				
				@Override
				public boolean onTouch(View view, MotionEvent motionEvent) {
					
					 if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
					
					 }
				     return true;
				}
			});*/
			iv.setOnDragListener(new View.OnDragListener() {

                @Override
                public boolean onDrag(View v, DragEvent event) {

                    boolean result = true;
                    int action = event.getAction();
                    switch (action) {
                    case DragEvent.ACTION_DRAG_STARTED:
                    	
                        break;
                    case DragEvent.ACTION_DRAG_LOCATION:
                        break;
                    case DragEvent.ACTION_DRAG_ENTERED:
                        v.setBackgroundResource(R.drawable.ic_launcher);
                        break;
                    case DragEvent.ACTION_DRAG_EXITED:
                        v.setBackgroundResource(R.color.a1);
                        break;
                    case DragEvent.ACTION_DROP:
                    	
                    	Log.i("cxsdaszdas", (int)iv.getTag()+"qw");
                    	
                    	dest=(int)iv.getTag();
                    	
                    	if(source!=dest)
                    	{
                    		al.add(source, al.get(source)+al.get(dest));
                    		notifyDataSetChanged();
                    	}
                       /* if (event.getLocalState() == v) {
                            result = false;
                        } else {
                            View droped = (View) event.getLocalState();
                            GridItem dropItem = ((DragGridItemHolder) droped.getTag()).item;

                            GridView parent = (GridView) droped.getParent();
                            DragGridAdapter adapter = (DragGridAdapter) parent.getAdapter();
                            List<GridItem> items = adapter.getItems();

                            View target = v;
                            GridItem targetItem = ((DragGridItemHolder) target.getTag()).item;
                            int index = items.indexOf(targetItem);
                            items.remove(dropItem);
                            items.add(index, dropItem);
                            adapter.notifyDataSetChanged();
                        }*/
                        break;
                    case DragEvent.ACTION_DRAG_ENDED:
                        //v.setBackgroundResource(R.drawable.ic_launcher);
                        break;
                    default:
                        result = false;
                        break;
                    }
                    return result;
                }
            });
			
			return view;
			
		}
		
	}
}
