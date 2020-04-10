package com.zsmart.accountingProject.ws.rest.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.zsmart.accountingProject.service.util.*;
import com.zsmart.accountingProject.bean.Cpc;
import com.zsmart.accountingProject.ws.rest.vo.CpcVo;

@Component
public class CpcConverter extends AbstractConverter<Cpc, CpcVo> {

	private boolean cpcSousClasses;

	@Autowired
	private CpcSousClasseConverter cpcSousClasseConverter;

	@Override
	public Cpc toItem(CpcVo vo) {
		if (vo == null) {
			return null;
		} else {
			Cpc item = new Cpc();

			if (StringUtil.isNotEmpty(vo.getReferenceSociete())) {
				item.setReferenceSociete(vo.getReferenceSociete());
			}

			if (vo.getId() != null) {
				item.setId(NumberUtil.toLong(vo.getId()));
			}

			if (vo.getDateDebut() != null) {
				item.setDateDebut(DateUtil.parse(vo.getDateDebut()));
			}

			if (vo.getDateFin() != null) {
				item.setDateFin(DateUtil.parse(vo.getDateFin()));
			}

			if (vo.getTotalCharge() != null) {
				item.setTotalCharge(NumberUtil.toBigDecimal(vo.getTotalCharge()));
			}

			if (vo.getTotalProduit() != null) {
				item.setTotalProduit(NumberUtil.toBigDecimal(vo.getTotalProduit()));
			}

			if (vo.getResultat() != null) {
				item.setResultat(NumberUtil.toBigDecimal(vo.getResultat()));
			}

			if (ListUtil.isNotEmpty(vo.getCpcSousClassesVo()) && cpcSousClasses) {
				item.setCpcSousClasses(cpcSousClasseConverter.toItem(vo.getCpcSousClassesVo()));
			}

			return item;
		}
	}

	@Override
	public CpcVo toVo(Cpc item) {
		if (item == null) {
			return null;
		} else {
			CpcVo vo = new CpcVo();

			if (StringUtil.isNotEmpty(item.getReferenceSociete())) {
				vo.setReferenceSociete(item.getReferenceSociete());
			}

			if (item.getId() != null) {
				vo.setId(NumberUtil.toString(item.getId()));
			}

			if (item.getDateDebut() != null) {
				vo.setDateDebut(DateUtil.formateDate(item.getDateDebut()));
			}

			if (item.getDateFin() != null) {
				vo.setDateFin(DateUtil.formateDate(item.getDateFin()));
			}

			if (item.getTotalCharge() != null) {
				vo.setTotalCharge(NumberUtil.toString(item.getTotalCharge()));
			}

			if (item.getTotalProduit() != null) {
				vo.setTotalProduit(NumberUtil.toString(item.getTotalProduit()));
			}

			if (item.getResultat() != null) {
				vo.setResultat(NumberUtil.toString(item.getResultat()));
			}

			if (ListUtil.isNotEmpty(item.getCpcSousClasses()) && cpcSousClasses) {
				vo.setCpcSousClassesVo(cpcSousClasseConverter.toVo(item.getCpcSousClasses()));
			}

			return vo;
		}
	}

	public void init() {

		cpcSousClasses = true;
	}
}
