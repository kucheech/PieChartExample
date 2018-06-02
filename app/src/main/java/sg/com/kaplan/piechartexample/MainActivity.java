package sg.com.kaplan.piechartexample;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PieChart pieChart = (PieChart) findViewById(R.id.piechart);

        List<PieEntry> entries = new ArrayList<>();

        entries.add(new PieEntry(18.5f, "Transport"));
        entries.add(new PieEntry(26.7f, "Entertainment"));
        entries.add(new PieEntry(24.0f, "School fees"));
        entries.add(new PieEntry(30.8f, "Food"));

        PieDataSet set = new PieDataSet(entries, "Expenses");
        set.setSliceSpace(8);
        set.setColors(new int[] {R.color.transport, R.color.entertainment, R.color.school, R.color.food}, this);
        PieData data = new PieData(set);
        data.setValueTextSize(24);
        pieChart.setData(data);
        pieChart.setEntryLabelTextSize(18);
        pieChart.setBackgroundColor(Color.parseColor("#FFAB91"));
        pieChart.setHoleColor(Color.parseColor("#FFFF00"));
        pieChart.getLegend().setEnabled(false); // hide legend
        Description d = new Description();
        d.setText("Monthly Expenses for Jun 2018");
        d.setTextSize(24);
        d.setPosition(980, 100);
        pieChart.setDescription(d);
        pieChart.invalidate(); // refresh
    }
}
