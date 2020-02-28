package com.safe.core.utils;

public class BaseUserInfo {
    private static Integer userId;
    private static Integer postId;
    private static Integer orgId;
    private static Integer accountId;
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		BaseUserInfo.userId = userId;
	}
	public Integer getPostId() {
		return postId;
	}
	public void setPostId(Integer postId) {
		BaseUserInfo.postId = postId;
	}
	public Integer getOrgId() {
		return orgId;
	}
	public void setOrgId(Integer orgId) {
		BaseUserInfo.orgId = orgId;
	}
	public Integer getAccountId() {
		return accountId;
	}
	public void setAccountId(Integer accountId) {
		BaseUserInfo.accountId = accountId;
	}
}
