package blogspot.xhdpi.contohrecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

  private RecyclerView recyclerView;

  private MainAdapter adapter;
  private List<Mobil> mobils;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

    setupRecyclerView();

    loadDataRecyclerView();
  }

  private void setupRecyclerView() {
    mobils = new ArrayList<>();
    adapter = new MainAdapter(this, mobils);

    recyclerView.setLayoutManager(new LinearLayoutManager(this));
    recyclerView.setAdapter(adapter);
  }

  /**
   * method untuk load data kedalam recyclerview, dalam contoh ini menggunakan data statis,
   * bisa dirubah dengan data dari api maupun database
   */
  private void loadDataRecyclerView() {
    for (int i = 0; i < 10; i++) {
      mobils.add(new Mobil("mobil " + i, "Merah " + i));
    }

    // notify ke adapter bahwa ada data yang terinsert
    adapter.notifyDataSetChanged();
  }
}
