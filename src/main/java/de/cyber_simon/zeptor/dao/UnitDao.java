package de.cyber_simon.zeptor.dao;

import de.cyber_simon.zeptor.entity.UnitEntity;

public interface UnitDao extends BaseDao<UnitEntity> {

	UnitEntity findByShortName(String shortname);
}
