package kk.play.stockmanagement.fragmentscycles;

import java.util.List;

import kk.play.stockmanagement.R;
import kk.play.stockmanagement.controller.CompanyListController;
import kk.play.stockmanagement.database.CyclesItemDBHandler;
import kk.play.stockmanagement.entity.Cycle;
import kk.play.stockmanagement.utils.ImageDownload;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class Others extends Fragment{
	private static final String ARG_SECTION_NUMBER = "section_number";

	private static final String fragment_tag="others";
	private static final String type="Others";

	public static Gents newInstance(int sectionNumber) {
		Gents fragment = new Gents();
		
		Bundle args = new Bundle();
		args.putInt(ARG_SECTION_NUMBER, sectionNumber);
		fragment.setArguments(args);
		return fragment;
	}

	public Others() {
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.cycles, container,
				false);
		
		
		CyclesItemDBHandler gentsHandler = new CyclesItemDBHandler(getActivity());
		List<Cycle> cycleList = gentsHandler.getCyclesByType(type);
		List<String> companies = gentsHandler.getListOfCompaniesBytype(type);

		CompanyListController controller=new CompanyListController();

		controller.createView(companies, rootView,getActivity(),type);

		return rootView;
	}
}
