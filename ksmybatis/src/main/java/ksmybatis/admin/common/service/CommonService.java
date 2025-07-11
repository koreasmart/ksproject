package ksmybatis.admin.common.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ksmybatis.admin.common.domain.CommonCode;
import ksmybatis.admin.common.mapper.CommonMapper;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class CommonService {

	private final CommonMapper commonMapper;
	
	/**
	 * 그룹코드에 일치하는 공통코드 목록조회
	 * @param groupCode
	 * @return List<CommonCode>
	 */
	public List<CommonCode> getCommonCodeListByGroupCode(String groupCode){
		return commonMapper.getCommonCodeListByGroupCode(groupCode);
	}
}















