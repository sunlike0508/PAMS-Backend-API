package com.pams.user.predicate;

import com.pams.common.util.CommonUtils;
import com.pams.user.dto.QUser;
import com.pams.user.dto.User;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;

public class UserPredicate {
	public static Predicate searchCondition(User user) {
		
		QUser userGroup = QUser.user;
		
		String userName = user.getName();
		String userGrade = user.getGrade();
		String userClubCode = user.getClubCode();
		String userRoleCode = user.getGrade();
		
		BooleanBuilder builder = new BooleanBuilder();
		
		if(!CommonUtils.isNull(userName)) {
			builder.and(userGroup.name.eq(userName));
		}
		if(!CommonUtils.isNull(userGrade)) {
			builder.and(userGroup.grade.eq(userGrade));
		}
		if(!CommonUtils.isNull(userClubCode)) {
			builder.and(userGroup.clubCode.eq(userClubCode));
		}
		if(!CommonUtils.isNull(userRoleCode)) {
			builder.and(userGroup.roleCode.eq(userRoleCode));
		}
		builder.and(userGroup.isActive.eq("1"));
		
		return builder;
	}

}
