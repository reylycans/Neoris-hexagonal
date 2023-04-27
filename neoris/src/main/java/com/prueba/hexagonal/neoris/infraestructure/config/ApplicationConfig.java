package com.prueba.hexagonal.neoris.infraestructure.config;

import com.prueba.hexagonal.neoris.application.port.in.ClientePort;
import com.prueba.hexagonal.neoris.application.port.in.CuentaPort;
import com.prueba.hexagonal.neoris.application.port.in.MovimientoPort;
import com.prueba.hexagonal.neoris.application.port.out.ClienteServicesPort;
import com.prueba.hexagonal.neoris.application.port.out.CuentaServicesPort;
import com.prueba.hexagonal.neoris.application.port.out.MovimientoServicesPort;
import com.prueba.hexagonal.neoris.application.services.ClienteServicesImpl;
import com.prueba.hexagonal.neoris.application.services.CuentaServiceImpl;
import com.prueba.hexagonal.neoris.application.services.MovimientoServicesImpl;
import com.prueba.hexagonal.neoris.domain.mapper.ClienteDataMapper;
import com.prueba.hexagonal.neoris.domain.mapper.CuentaDataMapper;
import com.prueba.hexagonal.neoris.domain.mapper.MovimientoDataMapper;
import com.prueba.hexagonal.neoris.infraestructure.port.out.cliente.adapter.ClienteRepositoryImpl;
import com.prueba.hexagonal.neoris.infraestructure.port.out.cliente.mapper.ClienteDataEntityMapper;
import com.prueba.hexagonal.neoris.infraestructure.port.out.cliente.repository.ClienteRepository;
import com.prueba.hexagonal.neoris.infraestructure.port.out.cuenta.adapter.CuentaRepositoryImpl;
import com.prueba.hexagonal.neoris.infraestructure.port.out.cuenta.mapper.CuentaEntityMapper;
import com.prueba.hexagonal.neoris.infraestructure.port.out.cuenta.repository.CuentaRepository;
import com.prueba.hexagonal.neoris.infraestructure.port.out.movimiento.adapter.MovimientoRepositoryImpl;
import com.prueba.hexagonal.neoris.infraestructure.port.out.movimiento.mapper.MovimientoDataEntityMapper;
import com.prueba.hexagonal.neoris.infraestructure.port.out.movimiento.repository.MovimientoRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
    @Bean
    public ClientePort clientePort(ClienteServicesPort clienteServicesPort,
                                   ClienteDataMapper clienteDataMapper){
        return new ClienteServicesImpl(clienteServicesPort,clienteDataMapper);
    }

    @Bean
    public CuentaPort cuentaPort(CuentaServicesPort cuentaServicesPort, CuentaDataMapper cuentaDataMapper){
        return new CuentaServiceImpl(cuentaServicesPort,cuentaDataMapper);
    }
    @Bean
    public ClienteServicesPort clienteServicesPort(ClienteRepository clienteRepository,
                                                   ClienteDataEntityMapper clienteDataEntityMapper){
        return new ClienteRepositoryImpl(clienteRepository,clienteDataEntityMapper);
    }
    @Bean
    public CuentaServicesPort cuentaServicesPort(CuentaRepository cuentaRepository,
                                                 CuentaEntityMapper cuentaEntityMapper){
        return new CuentaRepositoryImpl(cuentaRepository,cuentaEntityMapper);
    }
    @Bean
    public MovimientoServicesPort movimientoServicesPort(MovimientoRepository movimientoRepository,
                                                         MovimientoDataEntityMapper movimientoDataEntityMapper){
        return new MovimientoRepositoryImpl(movimientoRepository,movimientoDataEntityMapper);
    }
    @Bean
    public MovimientoPort movimientoPort(MovimientoServicesPort movimientoServicesPort,
                                         MovimientoDataMapper movimientoDataMapper,
                                         CuentaServicesPort cuentaServicesPort,
                                         ClienteServicesPort clienteServicesPort){
        return new MovimientoServicesImpl(movimientoServicesPort,movimientoDataMapper,cuentaServicesPort,clienteServicesPort);
    }
}
