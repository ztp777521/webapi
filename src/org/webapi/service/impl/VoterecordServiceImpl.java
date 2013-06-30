package org.webapi.service.impl;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.webapi.dao.VoterecordDao;
import org.webapi.entry.Voterecord;
import org.webapi.service.VoterecordService;

@Service
public class VoterecordServiceImpl extends BaseService<Voterecord> implements VoterecordService{

	public VoterecordDao voterecordDao = null;
	
	public VoterecordDao getVoterecordDao() {
		return voterecordDao;
	}

	@Resource
	public void setVoterecordDao(VoterecordDao voterecordDao) {
		this.voterecordDao = voterecordDao;
	}

	@PostConstruct
	public void initObject() {
		initBaseDao(voterecordDao);
	}

	/**
	 * 发起投票
	 */
	public Boolean addvotecode(Voterecord voterecord) throws Exception {
		try {
			this.save(voterecord);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
