package de.cyber_simon.zeptor.service;

import de.cyber_simon.zeptor.entity.UnitEntity;

public interface UnitService extends BaseService<UnitEntity> {

	UnitEntity findOrCreateByShortname(String shortname);

}
