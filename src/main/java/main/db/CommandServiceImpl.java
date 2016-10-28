package main.db;

import main.domain.Command;

import javax.annotation.Resource;

/**
 * Created by j on 10/28/16.
 */
public class CommandServiceImpl implements CommandService{
    @Resource
    CommandRepository commandRepository;

    @Override
    public Command findByDeviceId(String id) {
        return commandRepository.findBydeviceId(id);
    }

    @Override
    public void save(Command c) {
        commandRepository.save(c);
    }
}
