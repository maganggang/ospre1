package com.safe.core.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safe.core.beans.Account;
import com.safe.core.beans.Authority;
import com.safe.core.beans.ListMapVo;
import com.safe.core.beans.Module;
import com.safe.core.mapper.AccountMapper;
import com.safe.core.mapper.AuthorityMapper;
import com.safe.core.mapper.ModuleMapper;
import com.safe.core.service.AuthorityService;
import com.safe.core.utils.TreeUtils;
@Service
public class AuthorityServiceImpl implements AuthorityService{
	@Autowired
	private AuthorityMapper authorityMapper;
	@Autowired
	private AccountMapper accountMapper;
	@Autowired
	private ModuleMapper moduleMapper;
		public List<Authority> selectAll() {
			return authorityMapper.findAll();
		}

		public Authority selectByPrimaryKey(Integer id) {
			return authorityMapper.selectByPrimaryKey(id);
		}

		public Boolean deleteByPrimaryKey(Integer id) {
			int i=authorityMapper.deleteByPrimaryKey(id);
			if(i>0){
				return true;
			}
			return false;
		}

		public Authority update(Authority authority) {
		int i=authorityMapper.updateByPrimaryKeySelective(authority);
			if(i>0){
				return authority;
			}
			return null;
		}

		public Authority insert(Authority authority) {
			int i=authorityMapper.insertSelectiveReturnKey(authority);
			if(i>0){
				return authority;
			}
			return null;
		}

		public Account selectAuthority(Integer id) {
			Account account=accountMapper.selectMyAuth(id);
			List<ListMapVo> list=account.getModuleMapList();
			//list=TreeUtils.toTree(list, "id", "parentId");
			//System.out.println(TreeUtils.toTree(list, "id", "parentId"));
			account.setModuleMapList(TreeUtils.toTree(list, "id", "parentId"));
			return account;
		}

		@Override
		public List<Module> selectAuthorityById(Integer accountId, Integer parentId) {
			List<Module> list=moduleMapper.selectMyMenu(accountId, parentId);
			return list;
		}
}
