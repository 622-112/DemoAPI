package com.example.demo.domain.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.demo.domain.entity.world.SelectPopulatedCityEntity;

/**
 * WorldDbMapper.xml�Œ�`����SQL�̃C���^�[�t�F�[�X�N���X�ł��B
 * @author 510
 * @since 2022/02/13
 */
public interface WorldDbMapper {
	/**
	 * �����Ŏw�肵�����̐l���������s�s���3�����擾����B
	 * @param listCounrtyCode ���R�[�h���X�g
	 * @return SelectContinentEntity SelectPopulatedCity�G���e�B�e�B�N���X
	 */
	List<SelectPopulatedCityEntity> selectPopulatedCity(@Param("listCounrtyCode") List<String> listCounrtyCode);
}
