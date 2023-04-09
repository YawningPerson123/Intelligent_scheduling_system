package com.pilifenghuolang.ISS.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.pilifenghuolang.ISS.domain.Stuff;
import com.pilifenghuolang.ISS.schedule.Time;

import java.util.List;

public interface PreferenceService {

    public boolean savePreference(Time time);


    public boolean deletePreference(int id);

    public List<Time> getPreference(int stuffId);

}
