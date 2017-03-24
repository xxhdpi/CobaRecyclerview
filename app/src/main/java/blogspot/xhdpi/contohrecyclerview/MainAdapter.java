package blogspot.xhdpi.contohrecyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainHolder> {

  private Context context;
  private List<Mobil> mobils;

  public MainAdapter(Context context, List<Mobil> mobils) {
    this.context = context;
    this.mobils = mobils;
  }

  @Override public MainHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    return new MainHolder(
        LayoutInflater.from(context).inflate(R.layout.layout_item_mobil, parent, false));
  }

  @Override public void onBindViewHolder(MainHolder holder, int position) {
    holder.bindItem(mobils.get(position));
  }

  @Override public int getItemCount() {
    return mobils.size();
  }

  public class MainHolder extends RecyclerView.ViewHolder {

    private TextView name, color;

    public MainHolder(View itemView) {
      super(itemView);
      name = (TextView) itemView.findViewById(R.id.tvName);
      color = (TextView) itemView.findViewById(R.id.tvColor);
    }

    public void bindItem(Mobil mobil) {
      name.setText(mobil.name);
      color.setText(mobil.color);
    }
  }
}
