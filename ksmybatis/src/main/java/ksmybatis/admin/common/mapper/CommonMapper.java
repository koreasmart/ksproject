package ksmybatis.admin.common.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ksmybatis.admin.common.domain.CommonCode;

@Mapper
public interface CommonMapper {
	// 그룹코드에 일치하는 공통코드 목록조회
	List<CommonCode> getCommonCodeListByGroupCode(String groupCode);
}
