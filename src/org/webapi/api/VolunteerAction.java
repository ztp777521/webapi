

package org.webapi.api;

import javax.annotation.Resource;

import org.springside.modules.orm.Page;
import org.webapi.entry.Gridinfo;
import org.webapi.entry.Idea;
import org.webapi.entry.Ideareply;
import org.webapi.entry.Launchvote;
import org.webapi.entry.Volunteer;
import org.webapi.entry.Voterecord;
import org.webapi.entry.Votevolunteer;
import org.webapi.service.GridinfoService;
import org.webapi.service.IdeaService;
import org.webapi.service.IdeareplyService;
import org.webapi.service.LaunchvoteService;
import org.webapi.service.VolunteerService;
import org.webapi.service.VolunteergridService;
import org.webapi.service.VoterecordService;
import org.webapi.service.VotevolunteerService;

/**
 * 格长信息Action
 *
 */
public class VolunteerAction extends BaseAction<Volunteer>{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public VolunteerService volunteerService = null;
	public Volunteer volunteer = new Volunteer();
	public GridinfoService gridinfoService = null;
	public VolunteergridService volunteergridService = null;
	public IdeaService ideaService = null;
	public IdeareplyService ideareplyService = null;
	public Ideareply ideareply = new Ideareply();
	public LaunchvoteService launchvoteService = null;
	public VotevolunteerService votevolunteerService = null;
	public VoterecordService voterecordService = null;
	public Voterecord voterecord = new Voterecord();
	
	
	
	public Voterecord getVoterecord() {
		return voterecord;
	}

	public void setVoterecord(Voterecord voterecord) {
		this.voterecord = voterecord;
	}

	public VoterecordService getVoterecordService() {
		return voterecordService;
	}

	@Resource
	public void setVoterecordService(VoterecordService voterecordService) {
		this.voterecordService = voterecordService;
	}

	public VotevolunteerService getVotevolunteerService() {
		return votevolunteerService;
	}

	@Resource
	public void setVotevolunteerService(VotevolunteerService votevolunteerService) {
		this.votevolunteerService = votevolunteerService;
	}

	public LaunchvoteService getLaunchvoteService() {
		return launchvoteService;
	}

	@Resource
	public void setLaunchvoteService(LaunchvoteService launchvoteService) {
		this.launchvoteService = launchvoteService;
	}

	public Ideareply getIdeareply() {
		return ideareply;
	}

	public void setIdeareply(Ideareply ideareply) {
		this.ideareply = ideareply;
	}

	public IdeareplyService getIdeareplyService() {
		return ideareplyService;
	}

	@Resource
	public void setIdeareplyService(IdeareplyService ideareplyService) {
		this.ideareplyService = ideareplyService;
	}

	public IdeaService getIdeaService() {
		return ideaService;
	}

	public void setIdeaService(IdeaService ideaService) {
		this.ideaService = ideaService;
	}

	public VolunteergridService getVolunteergridService() {
		return volunteergridService;
	}

	@Resource
	public void setVolunteergridService(VolunteergridService volunteergridService) {
		this.volunteergridService = volunteergridService;
	}

	public GridinfoService getGridinfoService() {
		return gridinfoService;
	}

	@Resource
	public void setGridinfoService(GridinfoService gridinfoService) {
		this.gridinfoService = gridinfoService;
	}

	public VolunteerService getVolunteerService() {
		return volunteerService;
	}

	@Resource
	public void setVolunteerService(VolunteerService volunteerService) {
		this.volunteerService = volunteerService;
	}


	public Volunteer getVolunteer() {
		return volunteer;
	}


	public void setVolunteer(Volunteer volunteer) {
		this.volunteer = volunteer;
	}

	

	public Volunteer getModel() {
		return volunteer;
	}

	/**
	 * 查询网格编号
	 */
	public void findgridinfolist()
	{
		int pageno = 1;
		int pagesize = 100;
		try {
			Page<Gridinfo> page = gridinfoService.findgridinfolist(pageno,pagesize);
			setSuccessMessage(page);
		} catch (Exception e) {
			e.printStackTrace();
		}
		writeResponse(returnMsg);
	}
	
	/**
	 * 申请网格格长
	 */
	public void addvolunteer()
	{
		try {
			volunteer.setState(0);
			volunteer.setIspass(1);
			Boolean fals =  volunteerService.addvolunteer(volunteer);
			if(fals)
				setSuccessMessage("OK");
			else
				setSuccessMessage("ON");
		} catch (Exception e) {
			e.printStackTrace();
		}
		writeResponse(returnMsg);
	}
	
	/**
	 * 查询所有意见和回复
	 */
	public void findideareply()
	{
		String struserid = this.getRequest().getParameter("userid");
		String strispublic = this.getRequest().getParameter("ispublic");
		int userid = -1;
		int pageNo = 1;
		int pageSize = 10 ;
		int ispublic = -1;
		if(struserid != null && !(struserid.equals("")))
		{
			userid = Integer.parseInt(struserid);
		}
		if(strispublic != null && !(strispublic.equals("")))
		{
			ispublic = Integer.parseInt(strispublic);
		}
		try {
			Page<Idea> ideapage = ideaService.findidealist(userid,ispublic, pageNo, pageSize);
//			IdeareplyInfo ideareplyInfo = new IdeareplyInfo();
			if(ideapage.getResult().size() > 0)
			{
				for(int i = 0; i < ideapage.getResult().size();i++)
				{
					int ideaid = ideapage.getResult().get(i).getIdeaid();
					Page<Ideareply> ideareplypage = ideareplyService.findideareplylist(ideaid, pageNo, pageSize);
				}
			}
			setSuccessMessage(ideapage);
		} catch (Exception e) {
			e.printStackTrace();
		}
		writeResponse(returnMsg);
	}
	
	/**
	 * 提交意见
	 */
	public void addideareply()
	{
		try {
			Boolean fals = ideareplyService.addideareply(ideareply);
			setSuccessMessage(fals);
		} catch (Exception e) {
			e.printStackTrace();
		}
		writeResponse(returnMsg);
	}
	
	/**
	 * 查询未结束的发起投票列表
	 */
	public void findlaunchvote()
	{
		int pageNo = 1;
		int pageSize = 10;
		try {
			Page<Launchvote> launchpage = launchvoteService.findlaunchvotelist( pageNo, pageSize);
			setSuccessMessage(launchpage);
		} catch (Exception e) {
			e.printStackTrace();
		}
		writeResponse(returnMsg);
	}
	
	/**
	 * 查询将要进行投票的格长列表
	 */
	public void findvolunteer()
	{
		String strvoteid = this.getRequest().getParameter("voteid");
		int voteid = -1;
		int pageNo = 1;
		int pageSize = 10;
		if(strvoteid != null && !(strvoteid.equals("")))
		{
			voteid = Integer.parseInt(strvoteid);
		}
		try {
			Page<Votevolunteer> votepage = votevolunteerService.findvotevolunteer(voteid,pageNo,pageSize);
			setSuccessMessage(votepage);
		} catch (Exception e) {
			e.printStackTrace();
		}
		writeResponse(returnMsg);
	}
	
	/**
	 * 发起投票
	 */
	public void addvoterecode()
	{
		try {
			Boolean fals = voterecordService.addvotecode(voterecord);
			setSuccessMessage(fals);
		} catch (Exception e) {
			e.printStackTrace();
		}
		writeResponse(returnMsg);
	}
}
