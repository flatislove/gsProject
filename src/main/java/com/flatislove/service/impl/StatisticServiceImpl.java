package com.flatislove.service.impl;

import com.flatislove.model.Statistic;
import com.flatislove.model.repository.StatisticRepository;
import com.flatislove.service.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class StatisticServiceImpl implements StatisticService {

    private final
    StatisticRepository statisticRepository;

    @Autowired
    public StatisticServiceImpl(StatisticRepository statisticRepository) {
        this.statisticRepository = statisticRepository;
    }

    @Override
    public double getLastDayStatistic() {
        List<Statistic> statisticList = statisticRepository.findAll();
        double lastStatistic = statisticList.get(0).getStatisticSellingAfter();
        Date lastDay = statisticList.get(0).getStatisticDate();
        for (Statistic aStatisticList : statisticList) {
            if (aStatisticList.getStatisticDate().after(lastDay)) {
                lastDay = aStatisticList.getStatisticDate();
                lastStatistic = aStatisticList.getStatisticSellingAfter();
            }
        }
        return lastStatistic;
    }

    @Override
    public double getAllTimeStatistic() {
        List<Statistic> statistics = statisticRepository.findAll();
        double sum = 0;
        for (Statistic statistic : statistics) {
            sum += statistic.getStatisticSellingAfter();
        }
        return sum / statistics.size();
    }
}
