/*******************************************************************************
 * Copyright 2012 The University of North Carolina at Chapel Hill.
 *  All Rights Reserved.
 * 
 *  Permission to use, copy, modify OR distribute this software and its
 *  documentation for educational, research and non-profit purposes, without
 *  fee, and without a written agreement is hereby granted, provided that the
 *  above copyright notice and the following three paragraphs appear in all
 *  copies.
 * 
 *  IN NO EVENT SHALL THE UNIVERSITY OF NORTH CAROLINA AT CHAPEL HILL BE
 *  LIABLE TO ANY PARTY FOR DIRECT, INDIRECT, SPECIAL, INCIDENTAL, OR
 *  CONSEQUENTIAL DAMAGES, INCLUDING LOST PROFITS, ARISING OUT OF THE
 *  USE OF THIS SOFTWARE AND ITS DOCUMENTATION, EVEN IF THE UNIVERSITY
 *  OF NORTH CAROLINA HAVE BEEN ADVISED OF THE POSSIBILITY OF SUCH
 *  DAMAGES.
 * 
 *  THE UNIVERSITY OF NORTH CAROLINA SPECIFICALLY DISCLAIM ANY
 *  WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF
 *  MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE.  THE SOFTWARE
 *  PROVIDED HEREUNDER IS ON AN "AS IS" BASIS, AND THE UNIVERSITY OF
 *  NORTH CAROLINA HAS NO OBLIGATIONS TO PROVIDE MAINTENANCE, SUPPORT,
 *  UPDATES, ENHANCEMENTS, OR MODIFICATIONS.
 * 
 *  The authors may be contacted via:
 * 
 *  US Mail:           Dennis Goldfarb
 *                     Wei Wang
 * 
 *                     Department of Computer Science
 *                       Sitterson Hall, CB #3175
 *                       University of N. Carolina
 *                       Chapel Hill, NC 27599-3175
 * 
 *                     Ben Major
 * 
 *                     Department of Cell Biology and Physiology 
 *                       Lineberger Comprehensive Cancer Center
 *                       University of N. Carolina
 *                       Chapel Hill, NC 27599-3175
 * 
 *  Email:             dennisg@cs.unc.edu
 *                     weiwang@cs.unc.edu
 *                     ben_major@med.unc.edu
 * 
 *  Web:               www.unc.edu/~dennisg/
 ******************************************************************************/
package edu.unc.flashlight.client.ui.activity;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

import edu.unc.flashlight.client.ClientFactory;
import edu.unc.flashlight.client.Flashlight;
import edu.unc.flashlight.client.command.ServerOp;
import edu.unc.flashlight.client.ui.place.WelcomePlace;
import edu.unc.flashlight.client.ui.view.WelcomeView;
import edu.unc.flashlight.client.ui.widget.popup.DraggablePopup;
import edu.unc.flashlight.shared.model.upload.UploadResult;

public class WelcomeActivity extends AbstractActivity implements WelcomeView.Presenter{
	private ClientFactory clientFactory;
	
	public WelcomeActivity(WelcomePlace place, ClientFactory clientFactory) {
		this.clientFactory = clientFactory;
	}
	
	public void start(AcceptsOneWidget containerWidget, EventBus eventBus) {
		WelcomeView welcomeView = clientFactory.getWelcomeView();
		welcomeView.setPresenter(this);
		containerWidget.setWidget(welcomeView.asWidget());
		Flashlight.getMenu().updateCurrentMenu(Flashlight.getMenu().getHome());
	}
	
	public String mayStop() {
		return null;
	}
	
	public void goTo(Place place) {
		clientFactory.getPlaceController().goTo(place);
	}

	public void onBrowseButtonClicked() {
		Flashlight.placeController.goTo(Flashlight.getPlaceFactory().getBrowsePlace());
	}

	public void onUploadButtonClicked() {
		Flashlight.placeController.goTo(Flashlight.getPlaceFactory().getUploadPlace());
	}

	public void onAboutButtonClicked() {
		//new DraggablePopup().center();
		//new ExceptionPopup(new ColumnCountException(5,134)).center();
		Flashlight.placeController.goTo(Flashlight.getPlaceFactory().getAboutPlace());
	}
	
}
