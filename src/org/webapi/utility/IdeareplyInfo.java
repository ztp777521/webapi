package org.webapi.utility;

import java.util.List;

import org.webapi.entry.Idea;
import org.webapi.entry.Ideareply;

public class IdeareplyInfo {

	private List<Idea>  idealist;
	private List<Ideareply> ideareplylist;
	public List<Idea> getIdealist() {
		return idealist;
	}
	public void setIdealist(List<Idea> idealist) {
		this.idealist = idealist;
	}
	public List<Ideareply> getIdeareplylist() {
		return ideareplylist;
	}
	public void setIdeareplylist(List<Ideareply> ideareplylist) {
		this.ideareplylist = ideareplylist;
	}
}
